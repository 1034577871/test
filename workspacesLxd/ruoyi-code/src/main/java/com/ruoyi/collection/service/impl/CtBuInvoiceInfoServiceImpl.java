package com.ruoyi.collection.service.impl;

import java.math.BigDecimal;
import java.util.*;

import com.ruoyi.base.fileManage.domain.CtBuFile;
import com.ruoyi.base.fileManage.service.ICtBuFileService;
import com.ruoyi.collection.domain.CtBuInvoiceInfoReq;
import com.ruoyi.collection.domain.CtBuInvoiceReq;
import com.ruoyi.collection.domain.CtBuReceiptInfo;
import com.ruoyi.collection.mapper.CtBuInvoiceReqMapper;
import com.ruoyi.collection.mapper.CtBuReceiptInfoMapper;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.contract.contractInfo.domain.CtBuContract;
import com.ruoyi.contract.contractInfo.mapper.CtBuContractMapper;
import com.ruoyi.contract.payinfoInvoice.domain.CtBuPayinfoInvoice;
import com.ruoyi.contract.payinfoInvoice.mapper.CtBuPayinfoInvoiceMapper;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.collection.mapper.CtBuInvoiceInfoMapper;
import com.ruoyi.collection.domain.CtBuInvoiceInfo;
import com.ruoyi.collection.service.ICtBuInvoiceInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 财务开票Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-11
 */
@Service
public class CtBuInvoiceInfoServiceImpl implements ICtBuInvoiceInfoService 
{
    @Autowired
    private CtBuInvoiceInfoMapper ctBuInvoiceInfoMapper;
    @Autowired
    private CtBuReceiptInfoMapper ctBuReceiptInfoMapper;
    @Autowired
    private CtBuInvoiceReqMapper ctBuInvoiceReqMapper;

    @Autowired
    private ICtBuFileService fileService;

    @Autowired
    private CtBuPayinfoInvoiceMapper ctBuPayinfoInvoiceMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private CtBuContractMapper ctBuContractMapper;



    /**
     * 凭证号录入
     *
     * @param ids 需要删除的财务开票ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateVocherInfoByIds(String[] ids, String vocher, String date,String vodept,String status)
    {
        Map map = new HashMap();
        map.put("ids",ids);
        /** 判断当前登录人 **/
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (loginUser != null && loginUser.getUser() != null) {
            map.put("voucherUserid",loginUser.getUser().getUserId());
            map.put("voucherUsername",loginUser.getUser().getUserName());
            map.put("voucherTime",new Date());
            map.put("voucherNo",vocher);
            map.put("voucherDept",vodept);
            map.put("voucherMonth",date);
            if(!status.equals("100")){
                map.put("status",status);
            }


        }else{
            return 0;
        }

        return ctBuInvoiceInfoMapper.updateCtBuInvoiceInfoByIds(map);
    }

    /**
     * 移交财务开票
     *
     * @param ids 需要删除的财务开票ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateCtBuInvoiceInfoByIds(String[] ids,String flag)
    {
        Map map = new HashMap();
        map.put("ids",ids);
        /** 判断当前登录人 **/
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (loginUser != null && loginUser.getUser() != null) {
            if("0".equals(flag)){
                map.put("handoverUserid",loginUser.getUser().getUserId());
                map.put("handoverUsername",loginUser.getUser().getNickName());
                map.put("handoverTime",DateUtils.getNowDate());
                map.put("status","2");
            }else if("100".equals(flag)){
                map.put("status","8");
            } else{
                map.put("confirmerUserid",loginUser.getUser().getUserId());
                map.put("confirmerUsername",loginUser.getUser().getNickName());
                map.put("confirmerTime",DateUtils.getNowDate());
                map.put("status","3");
            }
        }else{
            return 0;
        }

        int num = ctBuInvoiceInfoMapper.updateCtBuInvoiceInfoByIds(map);
        if(num>0 && "100".equals(flag)){
            //String str1= StringUtils.join(ids, ",");
           // ctBuReceiptInfoMapper.updateCtBuReceiptInfoByIds( ids);
            for(String id :ids){
                CtBuInvoiceInfo ctBuInvoiceInfo = ctBuInvoiceInfoMapper.selectCtBuInvoiceInfoById(id);
                CtBuInvoiceReq ctBuInvoiceReq = ctBuInvoiceReqMapper.selectCtBuInvoiceReqById(ctBuInvoiceInfo.getReqId());
                if(ctBuInvoiceInfo!=null){
                    //修改合同主表
                    CtBuContract ctBuContract = new CtBuContract();
                    ctBuContract.setId(ctBuInvoiceReq.getContractId());
                    int i=(ctBuInvoiceReq.getInvoiceAmountTax()).compareTo(BigDecimal.ZERO);
                    if(i==-1){
                        Double dValue=-(ctBuInvoiceReq.getInvoiceAmountTax().doubleValue()); //转为Double
                        ctBuContract.setWriteOffAmount(new BigDecimal(dValue));
                    }else{
                        ctBuContract.setWriteOffAmount(ctBuInvoiceReq.getInvoiceAmountTax());
                    }
                    ctBuContractMapper.updateAddCtBuContract(ctBuContract);
                }
            }
        }

        return num;
    }


    /**
     * 凭证号录入
     * 
     * @param id 财务开票ID
     * @return 财务开票
     */
    @Override
    public CtBuInvoiceInfo selectCtBuInvoiceInfoById(String id)
    {
        return ctBuInvoiceInfoMapper.selectCtBuInvoiceInfoById(id);
    }

    /**
 * 查询财务开票列表
 *
 * @param ctBuInvoiceInfo 财务开票
 * @return 财务开票
 */
@Override
public List<CtBuInvoiceInfoReq> selectCtBuInvoiceInfoList(CtBuInvoiceInfoReq ctBuInvoiceInfo)
{
    return ctBuInvoiceInfoMapper.selectKpList(ctBuInvoiceInfo);
//    if(role==101){
//            ctBuInvoiceInfo.setStatus(2);
//        return ctBuInvoiceInfoMapper.selectCtBuInvoiceQrInfoList(ctBuInvoiceInfo);
//    }else{
//        return ctBuInvoiceInfoMapper.selectCtBuInvoiceInfoList(ctBuInvoiceInfo);
//    }

}
    @Override
    @DataScope(deptAlias = "U")
    public List<CtBuInvoiceInfo> selectCtBuInvoiceQrInfoandPzhsList(CtBuInvoiceInfo ctBuInvoiceInfo){
        return ctBuInvoiceInfoMapper.selectCtBuInvoiceQrInfoandPzhsList(ctBuInvoiceInfo);

    }

    /**
     * 新增财务开票
     * 
     * @param ctBuInvoiceInfo 财务开票
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertCtBuInvoiceInfo(CtBuInvoiceInfo ctBuInvoiceInfo)
    {
        /** 判断当前登录人 **/
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (loginUser != null && loginUser.getUser() != null) {
            ctBuInvoiceInfo.setCreateBy(loginUser.getUser().getUserId().toString());
        }
        ctBuInvoiceInfo.setDelFlag("1");
        String uuid = UUID.fastUUID().toString(true);
        ctBuInvoiceInfo.setId(uuid);
        ctBuInvoiceInfo.setCreateTime(DateUtils.getNowDate());

        /** 处理文件 **/
        if (org.apache.commons.lang3.StringUtils.isNotBlank(ctBuInvoiceInfo.getCompanyImg())) {
            String[] str = ctBuInvoiceInfo.getCompanyImg().split(",");
            for (int i = 0; i < str.length; i++) {
                /** 判断传入文件ID是否为空 **/
                if (StringUtils.isNotBlank(str[i])) {
                    CtBuFile file = new CtBuFile();
                    file.setId(str[i]);
                    file.setPtype(1);   //合同归档资料 ptype:1
                    file.setPid(ctBuInvoiceInfo.getId());
                    fileService.updateCtBuFile(file);
                }
            }
        }
        //发票图片
        if (org.apache.commons.lang3.StringUtils.isNotBlank(ctBuInvoiceInfo.getInvoiceImg())) {
            String[] str = ctBuInvoiceInfo.getInvoiceImg().split(",");
            for (int i = 0; i < str.length; i++) {
                /** 判断传入文件ID是否为空 **/
                if (StringUtils.isNotBlank(str[i])) {
                    CtBuFile file = new CtBuFile();
                    file.setId(str[i]);
                    file.setPtype(2);   //合同归档资料 ptype:1
                    file.setPid(ctBuInvoiceInfo.getId());
                    fileService.updateCtBuFile(file);
                }
            }
        }
        if(ctBuInvoiceInfo.getInvoiceDate()==null){
            ctBuInvoiceInfo.setInvoiceDate(new Date());
        }
        int num = ctBuInvoiceInfoMapper.insertCtBuInvoiceInfo(ctBuInvoiceInfo);
        if(num>0){
            CtBuInvoiceReq ctBuInvoiceReq = ctBuInvoiceReqMapper.selectCtBuInvoiceReqById(ctBuInvoiceInfo.getReqId());
            if(ctBuInvoiceReq!=null && ctBuInvoiceReq.getYskid()!=null && !"".equals(ctBuInvoiceReq.getYskid()) && ctBuInvoiceInfo.getStatus()==1){
                CtBuReceiptInfo ctBuReceiptInfo = new CtBuReceiptInfo();
                ctBuReceiptInfo.setId(ctBuInvoiceReq.getYskid());
                ctBuReceiptInfo.setInvoiceCode(ctBuInvoiceInfo.getInvoiceCode());
                ctBuReceiptInfo.setInvoiceNo(ctBuInvoiceInfo.getInvoiceNo());
                ctBuReceiptInfo.setInvoiceId(ctBuInvoiceInfo.getId());
                ctBuReceiptInfo.setProName(ctBuInvoiceReq.getProName());
                ctBuReceiptInfo.setProNo(ctBuInvoiceReq.getProNo());
                ctBuReceiptInfo.setContractNo(ctBuInvoiceReq.getContractNo());
                ctBuReceiptInfo.setContractName(ctBuInvoiceReq.getContractName());
                ctBuReceiptInfoMapper.updateCtBuReceiptInfo(ctBuReceiptInfo);
                //修改合同主表
                CtBuContract ctBuContract = new CtBuContract();
                ctBuContract.setId(ctBuInvoiceReq.getContractId());
                CtBuReceiptInfo ctBuReceiptInfos = ctBuReceiptInfoMapper.selectCtBuReceiptInfoById(ctBuInvoiceReq.getYskid());
                ctBuContract.setReceiveAmount(ctBuReceiptInfos.getCollectionAmount());
                ctBuContractMapper.updateAddCtBuContract(ctBuContract);
            }
            //修改合同收款信息表
            if(ctBuInvoiceInfo.getStatus()==1){
                CtBuPayinfoInvoice ctBuPayinfoInvoice = new CtBuPayinfoInvoice();
                ctBuPayinfoInvoice.setId(UUID.fastUUID().toString(true));
                ctBuPayinfoInvoice.setCreateTime(new Date());
                ctBuPayinfoInvoice.setContractId(ctBuInvoiceReq.getContractId());
                ctBuPayinfoInvoice.setPaymentCycleId(ctBuInvoiceReq.getPayinfoid());
                ctBuPayinfoInvoice.setBid(uuid);
                ctBuPayinfoInvoice.setInvoiceNo(ctBuInvoiceInfo.getInvoiceNo());
                ctBuPayinfoInvoice.setInvoiceCode(ctBuInvoiceInfo.getInvoiceCode());
                ctBuPayinfoInvoice.setInvoiceMoney(ctBuInvoiceInfo.getInvoiceAmountTax());
                ctBuPayinfoInvoice.setInvoiceNomoney(ctBuInvoiceInfo.getInvoiceAmountNtax());
                ctBuPayinfoInvoice.setInvoiceTime(new Date());
                ctBuPayinfoInvoice.setDelFlag(1);
                ctBuPayinfoInvoice.setCreateBy(loginUser.getUser().getUserName());
                ctBuPayinfoInvoiceMapper.insertCtBuPayinfoInvoice(ctBuPayinfoInvoice);
                //生成一条负数记录

            }

        }
        return num;
    }

    /**
     * 修改财务开票
     * 
     * @param ctBuInvoiceInfo 财务开票
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateCtBuInvoiceInfo(CtBuInvoiceInfo ctBuInvoiceInfo)
    {
        /** 判断当前登录人 **/
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (loginUser != null && loginUser.getUser() != null) {
            ctBuInvoiceInfo.setUpdateBy(loginUser.getUser().getUserId().toString());
        }
        ctBuInvoiceInfo.setUpdateTime(DateUtils.getNowDate());


        /** 处理文件 **/
        if (org.apache.commons.lang3.StringUtils.isNotBlank(ctBuInvoiceInfo.getCompanyImg())) {
            String[] str = ctBuInvoiceInfo.getCompanyImg().split(",");
            for (int i = 0; i < str.length; i++) {
                /** 判断传入文件ID是否为空 **/
                if (StringUtils.isNotBlank(str[i])) {
                    CtBuFile file = new CtBuFile();
                    file.setId(str[i]);
                    file.setPtype(1);   //合同归档资料 ptype:1
                    file.setPid(ctBuInvoiceInfo.getId());
                    fileService.updateCtBuFile(file);
                }
            }
        }
        //发票图片
        if (org.apache.commons.lang3.StringUtils.isNotBlank(ctBuInvoiceInfo.getInvoiceImg())) {
            String[] str = ctBuInvoiceInfo.getInvoiceImg().split(",");
            for (int i = 0; i < str.length; i++) {
                /** 判断传入文件ID是否为空 **/
                if (StringUtils.isNotBlank(str[i])) {
                    CtBuFile file = new CtBuFile();
                    file.setId(str[i]);
                    file.setPtype(2);   //合同归档资料 ptype:1
                    file.setPid(ctBuInvoiceInfo.getId());
                    fileService.updateCtBuFile(file);
                }
            }
        }

        int num = ctBuInvoiceInfoMapper.updateCtBuInvoiceInfo(ctBuInvoiceInfo);
        if(num>0){
            CtBuInvoiceReq ctBuInvoiceReq = ctBuInvoiceReqMapper.selectCtBuInvoiceReqById(ctBuInvoiceInfo.getReqId());
            if(ctBuInvoiceReq!=null && ctBuInvoiceReq.getYskid()!=null && !"".equals(ctBuInvoiceReq.getYskid()) && ctBuInvoiceInfo.getStatus()==1){
                CtBuReceiptInfo ctBuReceiptInfo = new CtBuReceiptInfo();
                ctBuReceiptInfo.setId(ctBuInvoiceReq.getYskid());
                ctBuReceiptInfo.setInvoiceCode(ctBuInvoiceInfo.getInvoiceCode());
                ctBuReceiptInfo.setInvoiceNo(ctBuInvoiceInfo.getInvoiceNo());
                ctBuReceiptInfo.setInvoiceId(ctBuInvoiceInfo.getId());
                ctBuReceiptInfo.setProName(ctBuInvoiceReq.getProName());
                ctBuReceiptInfo.setProNo(ctBuInvoiceReq.getProNo());
                ctBuReceiptInfo.setContractNo(ctBuInvoiceReq.getContractNo());
                ctBuReceiptInfo.setContractName(ctBuInvoiceReq.getContractName());
                ctBuReceiptInfoMapper.updateCtBuReceiptInfo(ctBuReceiptInfo);

                //修改合同主表
//                CtBuContract ctBuContract = new CtBuContract();
//                ctBuContract.setId(ctBuInvoiceReq.getContractId());
//                CtBuReceiptInfo ctBuReceiptInfos = ctBuReceiptInfoMapper.selectCtBuReceiptInfoById(ctBuInvoiceReq.getYskid());
//                ctBuContract.setReceiveAmount(ctBuReceiptInfos.getCollectionAmount());
//                ctBuContractMapper.updateAddCtBuContract(ctBuContract);
            }

            //修改合同收款信息表
            if(ctBuInvoiceInfo.getStatus()==1){
                CtBuPayinfoInvoice ctBuPayinfoInvoice = new CtBuPayinfoInvoice();
                ctBuPayinfoInvoice.setId(UUID.fastUUID().toString(true));
                ctBuPayinfoInvoice.setCreateTime(new Date());
                ctBuPayinfoInvoice.setContractId(ctBuInvoiceReq.getContractId());
                ctBuPayinfoInvoice.setPaymentCycleId(ctBuInvoiceReq.getPayinfoid());
                ctBuPayinfoInvoice.setBid(ctBuInvoiceInfo.getId());
                ctBuPayinfoInvoice.setInvoiceNo(ctBuInvoiceInfo.getInvoiceNo());
                ctBuPayinfoInvoice.setInvoiceCode(ctBuInvoiceInfo.getInvoiceCode());
                ctBuPayinfoInvoice.setInvoiceMoney(ctBuInvoiceInfo.getInvoiceAmountTax());
                ctBuPayinfoInvoice.setInvoiceNomoney(ctBuInvoiceInfo.getInvoiceAmountNtax());
                ctBuPayinfoInvoice.setInvoiceTime(new Date());
                ctBuPayinfoInvoice.setDelFlag(1);
                ctBuPayinfoInvoice.setCreateBy(loginUser.getUser().getUserName());
                ctBuPayinfoInvoiceMapper.insertCtBuPayinfoInvoice(ctBuPayinfoInvoice);
            }

        }
        return num;
    }

    /**
     * 批量删除财务开票
     * 
     * @param ids 需要删除的财务开票ID
     * @return 结果
     */
    @Override
    public int deleteCtBuInvoiceInfoByIds(String[] ids)
    {
        return ctBuInvoiceInfoMapper.deleteCtBuInvoiceInfoByIds(ids);
    }

    /**
     * 删除财务开票信息
     * 
     * @param id 财务开票ID
     * @return 结果
     */
    @Override
    public int deleteCtBuInvoiceInfoById(String id)
    {
        return ctBuInvoiceInfoMapper.deleteCtBuInvoiceInfoById(id);
    }


    /**
     * 任意时间段开票统计（根据公司）
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List invoiceStatistics(Date startDate, Date endDate) {
        List<SysDept> sysDepts = sysDeptMapper.selectDeptByParentId(200L);
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        if (sysDepts != null && sysDepts.size() != 0){
            for (SysDept sd : sysDepts){
                if (sd.getDeptId() != null){

                    HashMap<String, Object> map = new HashMap<>();
                    int i1 = ctBuInvoiceInfoMapper.invoiceStatistics(sd.getDeptId(), 1, startDate, endDate);
                    int i2 = ctBuInvoiceInfoMapper.invoiceStatistics(sd.getDeptId(), 2, startDate, endDate);
                    map.put("companyId",sd.getDeptId());
                    map.put("companyName",sd.getDeptName());
                    //专票
                    map.put("specialInvoiceCount",i1);
                    //普票
                    map.put("plainInvoiceCount",i2);
                    list.add(map);
                }
            }
        }

        return list;
    }


    /**
     * 任意时间段开票统计（根据公司）
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List invoiceStatistics1(Date startDate, Date endDate) {
        List<SysDept> sysDepts = sysDeptMapper.selectDeptByParentId(200L);
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        if (sysDepts != null && sysDepts.size() != 0){
            for (SysDept sd : sysDepts){
                if (sd.getDeptId() != null){

                    HashMap<String, Object> stringObjectHashMap = ctBuInvoiceInfoMapper.invoiceStatistics1(sd.getDeptId(), startDate, endDate);
                    stringObjectHashMap.put("companyId",sd.getDeptId());
                    stringObjectHashMap.put("companyName",sd.getDeptName());
                    list.add(stringObjectHashMap);
                }
            }
        }

        return list;
    }

    /**
     * 查询本月未录入凭证号列表
     * @return
     */
    @Override
    public List<CtBuInvoiceInfo> voucherWarning() {
        return ctBuInvoiceInfoMapper.voucherWarning();

    }

    @Override
    public List<CtBuInvoiceInfoReq>  selectTotalInfo(CtBuInvoiceInfoReq ctBuInvoiceInfoReq){
        return ctBuInvoiceInfoMapper.selectTotalInfo(ctBuInvoiceInfoReq);
    }
}
