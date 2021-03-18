package com.ruoyi.collection.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.json.JSONUtil;
import com.ruoyi.base.fileManage.domain.CtBuFile;
import com.ruoyi.base.fileManage.service.ICtBuFileService;
import com.ruoyi.collection.domain.*;
import com.ruoyi.collection.mapper.CtBuInvoiceInfoMapper;
import com.ruoyi.collection.mapper.CtBuInvoiceReqMapper;
import com.ruoyi.collection.service.ICtBuInvoiceInfoService;
import com.ruoyi.collection.utils.ActUtils;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.contract.contractInfo.domain.CtBuContract;
import com.ruoyi.contract.contractInfo.mapper.CtBuContractMapper;
import com.ruoyi.mq.bean.SysConstant;
import com.ruoyi.mq.service.MsgService;
import com.ruoyi.projectApproval.ApprovalNg.mapper.CtBuApprovalNgMapper;
import com.ruoyi.system.service.ISysUserService;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.collection.mapper.CtBuReceiptInfoMapper;
import com.ruoyi.collection.service.ICtBuReceiptInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 收款单录入Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-10
 */
@Service
public class CtBuReceiptInfoServiceImpl implements ICtBuReceiptInfoService 
{
    @Autowired
    private CtBuReceiptInfoMapper ctBuReceiptInfoMapper;

    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    private TaskRuntime taskRuntime;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private TaskService taskService;

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private CtBuApprovalNgMapper ctBuApprovalNgMapper;

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private com.ruoyi.collection.service.ICtBuInvoiceInfoService iCtBuInvoiceInfoService;

    @Autowired
    private CtBuInvoiceReqMapper ctBuInvoiceReqMapper;
    @Autowired
    private ICtBuFileService fileService;
    @Autowired
    private MsgService msgService;

    @Autowired
    private  CtBuInvoiceInfoMapper ctBuInvoiceInfoMapper;

    @Autowired
    private  CtBuContractMapper ctBuContractMapper;

    @Autowired
    private  ICtBuReceiptInfoService iCtBuReceiptInfoService;

    /**
     * 查询收款单录入
     * 
     * @param id 收款单录入ID
     * @return 收款单录入
     */
    @Override
    public CtBuReceiptInfo selectCtBuReceiptInfoById(String id)
    {

        CtBuReceiptInfo info = ctBuReceiptInfoMapper.selectCtBuReceiptInfoById(id);
        if(info!=null && info.getId()!=null){

            ActWorkflowFormDatas data = new ActWorkflowFormDatas();
            data.setBusinessKey(info.getId());
            List<ActWorkflowFormDatas> alist = ctBuInvoiceReqMapper.selectGroupActWorkflowFormDataLists(data);
            info.setActWorkflowFormData(alist);
        }
        return info;
    }

    /**
     * 查询收款单录入列表
     * 
     * @param ctBuReceiptInfo 收款单录入
     * @return 收款单录入
     */
    @Override
    public List<CtBuReceiptInfo> selectCtBuReceiptInfoList(CtBuReceiptInfo ctBuReceiptInfo)
    {
        return ctBuReceiptInfoMapper.selectCtBuReceiptInfoList(ctBuReceiptInfo);
    }
    @Override
    public List<CtBuReceiptInfo> selectCtBuReceiptInfoList_(CtBuReceiptInfo ctBuReceiptInfo)
    {
        return ctBuReceiptInfoMapper.selectCtBuReceiptInfoList_(ctBuReceiptInfo);
    }
    @Override
    public List<CtBuReceiptInfo> selectHxCtBuReceiptInfoList(CtBuReceiptInfo ctBuReceiptInfo)
    {
        return ctBuReceiptInfoMapper.selectHxCtBuReceiptInfoList(ctBuReceiptInfo);
    }

    /**
     * 新增收款单录入
     * 
     * @param ctBuReceiptInfo 收款单录入
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertCtBuReceiptInfo(CtBuReceiptInfo ctBuReceiptInfo)
    {
        /** 判断当前登录人 **/
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (loginUser != null && loginUser.getUser() != null) {
            ctBuReceiptInfo.setCreateBy(loginUser.getUser().getUserId().toString());
        }
        String uuid = UUID.fastUUID().toString(true);
        ctBuReceiptInfo.setCreateTime(DateUtils.getNowDate());
        ctBuReceiptInfo.setDelFlag("1");
        ctBuReceiptInfo.setId(uuid);
        ctBuReceiptInfo.setCreateTime(DateUtils.getNowDate());

        //实列
        if(("1".equals(ctBuReceiptInfo.getStatus()) || ctBuReceiptInfo.getStatus()==1)){
            //获取当前登陆人的所属部门
            long dept_id = loginUser.getUser().getDept().getDeptId();
            Map<String, Object> variables = this.getVarirs(loginUser);
            variables.put("apply",loginUser.getUsername());
            String widthName = "收款单审核-"+loginUser.getUser().getNickName();
            String key ="invoiceAudit";
            ctBuReceiptInfo.setInstanceId(ActUtils.submitTask(processRuntime,loginUser,ctBuReceiptInfo.getId(),variables
                    ,taskService,taskRuntime,key,widthName));

            //修改info表信息
            CtBuInvoiceInfo info = new CtBuInvoiceInfo();
            info.setId(ctBuReceiptInfo.getIds());
            info.setStatus(5);
            iCtBuInvoiceInfoService.updateCtBuInvoiceInfo(info);

            // 根据流程实例Id查询任务
            Map map = new HashMap();
            map.put("instanceId",ctBuReceiptInfo.getInstanceId());
            map.put("name",widthName);
            msgService.sendDelayMsgToMQ(SysConstant.SYS_NG_EXCHANGE,SysConstant.SYS_NG_KEY, JSONUtil.toJsonStr(map),0);//30秒钟后执行

        }

        int num = ctBuReceiptInfoMapper.insertCtBuReceiptInfo(ctBuReceiptInfo);
        //发票图片
        if (org.apache.commons.lang3.StringUtils.isNotBlank(ctBuReceiptInfo.getVoucher())) {
            String[] str = ctBuReceiptInfo.getVoucher().split(",");
            for (int i = 0; i < str.length; i++) {
                /** 判断传入文件ID是否为空 **/
                if (StringUtils.isNotBlank(str[i])) {
                    CtBuFile file = new CtBuFile();
                    file.setId(str[i]);
                    file.setPtype(1);   //合同归档资料 ptype:1
                    file.setPid(ctBuReceiptInfo.getId());
                    fileService.updateCtBuFile(file);
                }
            }
        }
        if(num>0){
            if(ctBuReceiptInfo.getStatus()==2){
                //是否进行核销  查询申请金额
                //CtBuInvoiceInfoReq req = new CtBuInvoiceInfoReq();

                CtBuInvoiceReq req = ctBuInvoiceReqMapper.selectCtBuInvoiceReqById(ctBuReceiptInfo.getReqId() == null ? ctBuReceiptInfo.getReqIds() : ctBuReceiptInfo.getReqId());
                CtBuInvoiceInfoReq reqs = new CtBuInvoiceInfoReq();
                reqs.setReqId(ctBuReceiptInfo.getReqId());
                List<CtBuInvoiceInfoReq> list = ctBuInvoiceInfoMapper.selectRecInfoByRqId(reqs);
                if(list!=null && list.size()>0){
                    reqs = list.get(0);
                    BigDecimal a = (req.getInvoiceAmountTax());
                    // a = a.add(req.getInvoiceAmountTax());
                    BigDecimal b = (new BigDecimal(reqs.getInvoiceAmountTax1()));
                    CtBuContract ctBuContract = new CtBuContract();
                    //CtBuReceiptInfo ctBuReceiptInfo = iCtBuReceiptInfoService.selectCtBuReceiptInfoById(businessKey);
                    CtBuContract ctBuContract1 = ctBuContractMapper.selectCtBuContractById(ctBuReceiptInfo.getContractId());
                    if((a.compareTo(b)==0) ){

                        ctBuContract.setId(ctBuReceiptInfo.getContractId());
                        ctBuContract.setReceiveAmount((ctBuContract1.getReceiveAmount()==null?new BigDecimal(0):ctBuContract1.getReceiveAmount()).add(ctBuReceiptInfo.getCollectionAmount()));
                        ctBuContract.setOutstandingAmount((ctBuContract1.getTotalMoney()==null?new BigDecimal(0):ctBuContract1.getTotalMoney()).subtract((ctBuContract1.getReceiveAmount()==null?new BigDecimal(0):ctBuContract1.getReceiveAmount()).add(ctBuReceiptInfo.getCollectionAmount()==null?new BigDecimal(0):ctBuReceiptInfo.getCollectionAmount())));
                        ctBuContract.setWriteOffAmount((ctBuContract1.getWriteOffAmount()==null?new BigDecimal(0):ctBuContract1.getWriteOffAmount()).add(req.getInvoiceAmountTax()));
                        ctBuContract.setNwriteOffAmount((ctBuContract1.getTotalMoney()==null?new BigDecimal(0):ctBuContract1.getTotalMoney()).subtract(ctBuContract1.getWriteOffAmount()==null?new BigDecimal(0):ctBuContract1.getWriteOffAmount()));
                        ctBuContractMapper.updateCtBuContractAddReceiver(ctBuContract);
                    }else{
                        ctBuContract.setId(ctBuReceiptInfo.getContractId());
                        ctBuContract.setReceiveAmount((ctBuContract1.getReceiveAmount()==null?new BigDecimal(0):ctBuContract1.getReceiveAmount()).add(ctBuReceiptInfo.getCollectionAmount()));
                        ctBuContract.setOutstandingAmount((ctBuContract1.getTotalMoney()==null?new BigDecimal(0):ctBuContract1.getTotalMoney()).subtract((ctBuContract1.getReceiveAmount()==null?new BigDecimal(0):ctBuContract1.getReceiveAmount()).add(ctBuReceiptInfo.getCollectionAmount()==null?new BigDecimal(0):ctBuReceiptInfo.getCollectionAmount())));
                        ctBuContractMapper.updateCtBuContractAddReceiver(ctBuContract);
                    }

                }else{
                    CtBuContract ctBuContract = new CtBuContract();
//                    CtBuReceiptInfo ctBuReceiptInfo = iCtBuReceiptInfoService.selectCtBuReceiptInfoById(businessKey);
                    ctBuContract.setId(ctBuReceiptInfo.getContractId());
                    ctBuContract.setReceiveAmount(ctBuReceiptInfo.getCollectionAmount());
                    ctBuContract.setOutstandingAmount(ctBuReceiptInfo.getCollectionAmount());
                    ctBuContractMapper.updateCtBuContractAddReceiver(ctBuContract);
                }
            }
        }
        return num;
    }

    /**
     * 修改收款单录入
     * 
     * @param ctBuReceiptInfo 收款单录入
     * @return 结果
     */
    @Override
    public int updateCtBuReceiptInfo(CtBuReceiptInfo ctBuReceiptInfo)
    {
        /** 判断当前登录人 **/
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (loginUser != null && loginUser.getUser() != null) {
            ctBuReceiptInfo.setUpdateBy(loginUser.getUser().getUserId().toString());
        }
        ctBuReceiptInfo.setUpdateTime(DateUtils.getNowDate());


        //实列
        if(ctBuReceiptInfo.getStatus()==1){
            long dept_id = loginUser.getUser().getDept().getDeptId();
            Map<String, Object> variables = this.getVarirs(loginUser);
            variables.put("apply",loginUser.getUsername());
            String widthName = "收款单审核-"+loginUser.getUser().getNickName();
            String key ="invoiceAudit";
            ctBuReceiptInfo.setInstanceId(ActUtils.submitTask(processRuntime,loginUser,ctBuReceiptInfo.getId(),variables
                    ,taskService,taskRuntime,key,widthName));

            //修改info表信息
            CtBuInvoiceInfo info = new CtBuInvoiceInfo();
            info.setId(ctBuReceiptInfo.getIds());
            info.setStatus(5);
            iCtBuInvoiceInfoService.updateCtBuInvoiceInfo(info);
        }

        //发票图片
        if (org.apache.commons.lang3.StringUtils.isNotBlank(ctBuReceiptInfo.getVoucher())) {
            String[] str = ctBuReceiptInfo.getVoucher().split(",");
            for (int i = 0; i < str.length; i++) {
                /** 判断传入文件ID是否为空 **/
                if (StringUtils.isNotBlank(str[i])) {
                    CtBuFile file = new CtBuFile();
                    file.setId(str[i]);
                    file.setPtype(1);   //合同归档资料 ptype:1
                    file.setPid(ctBuReceiptInfo.getId());
                    fileService.updateCtBuFile(file);
                }
            }
        }

        int num =  ctBuReceiptInfoMapper.updateCtBuReceiptInfo(ctBuReceiptInfo);
        if(num>0){
            if(ctBuReceiptInfo.getStatus()==2){
                //是否进行核销  查询申请金额
                //CtBuInvoiceInfoReq req = new CtBuInvoiceInfoReq();

                CtBuInvoiceReq req = ctBuInvoiceReqMapper.selectCtBuInvoiceReqById(ctBuReceiptInfo.getReqId() == null ? ctBuReceiptInfo.getReqIds() : ctBuReceiptInfo.getReqId());
                CtBuInvoiceInfoReq reqs = new CtBuInvoiceInfoReq();
                reqs.setReqId(ctBuReceiptInfo.getReqId());
                List<CtBuInvoiceInfoReq> list = ctBuInvoiceInfoMapper.selectRecInfoByRqId(reqs);
                if(list!=null && list.size()>0){
                    reqs = list.get(0);
                    BigDecimal a = (req.getInvoiceAmountTax());
                    // a = a.add(req.getInvoiceAmountTax());
                    BigDecimal b = (new BigDecimal(reqs.getInvoiceAmountTax1()));
                    CtBuContract ctBuContract = new CtBuContract();
                    //CtBuReceiptInfo ctBuReceiptInfo = iCtBuReceiptInfoService.selectCtBuReceiptInfoById(businessKey);
                    CtBuContract ctBuContract1 = ctBuContractMapper.selectCtBuContractById(ctBuReceiptInfo.getContractId());
                    if((a.compareTo(b)==0) ){

                        ctBuContract.setId(ctBuReceiptInfo.getContractId());
                        ctBuContract.setReceiveAmount((ctBuContract1.getReceiveAmount()==null?new BigDecimal(0):ctBuContract1.getReceiveAmount()).add(ctBuReceiptInfo.getCollectionAmount()));
                        ctBuContract.setOutstandingAmount((ctBuContract1.getTotalMoney()==null?new BigDecimal(0):ctBuContract1.getTotalMoney()).subtract((ctBuContract1.getReceiveAmount()==null?new BigDecimal(0):ctBuContract1.getReceiveAmount()).add(ctBuReceiptInfo.getCollectionAmount()==null?new BigDecimal(0):ctBuReceiptInfo.getCollectionAmount())));
                        ctBuContract.setWriteOffAmount((ctBuContract1.getWriteOffAmount()==null?new BigDecimal(0):ctBuContract1.getWriteOffAmount()).add(req.getInvoiceAmountTax()));
                        ctBuContract.setNwriteOffAmount((ctBuContract1.getTotalMoney()==null?new BigDecimal(0):ctBuContract1.getTotalMoney()).subtract(ctBuContract1.getWriteOffAmount()==null?new BigDecimal(0):ctBuContract1.getWriteOffAmount()));
                        ctBuContractMapper.updateCtBuContractAddReceiver(ctBuContract);
                    }else{
                        ctBuContract.setId(ctBuReceiptInfo.getContractId());
                        ctBuContract.setReceiveAmount((ctBuContract1.getReceiveAmount()==null?new BigDecimal(0):ctBuContract1.getReceiveAmount()).add(ctBuReceiptInfo.getCollectionAmount()));
                        ctBuContract.setOutstandingAmount((ctBuContract1.getTotalMoney()==null?new BigDecimal(0):ctBuContract1.getTotalMoney()).subtract((ctBuContract1.getReceiveAmount()==null?new BigDecimal(0):ctBuContract1.getReceiveAmount()).add(ctBuReceiptInfo.getCollectionAmount()==null?new BigDecimal(0):ctBuReceiptInfo.getCollectionAmount())));
                        ctBuContractMapper.updateCtBuContractAddReceiver(ctBuContract);
                    }

                }else{
                    CtBuContract ctBuContract = new CtBuContract();
//                    CtBuReceiptInfo ctBuReceiptInfo = iCtBuReceiptInfoService.selectCtBuReceiptInfoById(businessKey);
                    ctBuContract.setId(ctBuReceiptInfo.getContractId());
                    ctBuContract.setReceiveAmount(ctBuReceiptInfo.getCollectionAmount());
                    ctBuContract.setOutstandingAmount(ctBuReceiptInfo.getCollectionAmount());
                    ctBuContractMapper.updateCtBuContractAddReceiver(ctBuContract);
                }
            }
        }
        return num;
    }


    /**
     * 修改收款单录入
     *
     * @param ctBuReceiptInfo 收款单录入
     * @return 结果
     */
    @Override
    public int updateEndCtBuReceiptInfo(CtBuReceiptInfo ctBuReceiptInfo)
    {
        /** 判断当前登录人 **/
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (loginUser != null && loginUser.getUser() != null) {
            ctBuReceiptInfo.setUpdateBy(loginUser.getUser().getUserId().toString());
        }
        ctBuReceiptInfo.setUpdateTime(DateUtils.getNowDate());

        return ctBuReceiptInfoMapper.updateEndCtBuReceiptInfo(ctBuReceiptInfo);
    }


    //获取组人员
    public Map<String,Object> getVarirs( LoginUser loginUser ){
        Map<String,Object> variables = new HashMap();
        List<String> ulist = new ArrayList();
        long dept_id = 100000;
        if("2".equals(loginUser.getUser().getUserType())){
            variables.put("jbrstate",2);
            //分公司财务人员
            dept_id = loginUser.getUser().getDeptId();
            variables.put("skdfgscwsh", ActUtils.getVarirs(dept_id,"103",iSysUserService));
        }
        if("1".equals(loginUser.getUser().getUserType())){
            dept_id = loginUser.getUser().getDeptId();
            variables.put("bbcwsh", ActUtils.getVarirs(null,"105",iSysUserService));
            variables.put("jbrstate",1);
        }
        return variables;
    }
    /**
     * 批量删除收款单录入
     * 
     * @param ids 需要删除的收款单录入ID
     * @return 结果
     */
    @Override
    public int deleteCtBuReceiptInfoByIds(String[] ids)
    {
        return ctBuReceiptInfoMapper.deleteCtBuReceiptInfoByIds(ids);
    }

    /**
     * 删除收款单录入信息
     * 
     * @param id 收款单录入ID
     * @return 结果
     */
    @Override
    public int deleteCtBuReceiptInfoById(String id)
    {
        return ctBuReceiptInfoMapper.deleteCtBuReceiptInfoById(id);
    }

    /**
     * 查询收款单录入列表
     *
     * @param ctBuReceiptInfo 收款单录入
     * @return 收款单录入
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<CtBuReceiptInfo> selectNewCtBuReceiptInfoList(CtBuReceiptInfo ctBuReceiptInfo)
    {
//        List<CtBuReceiptInfo> ctBuReceiptInfos = ctBuReceiptInfoMapper.selectNewCtBuReceiptInfoList(ctBuReceiptInfo);
        return ctBuReceiptInfoMapper.selectNewCtBuReceiptInfoList(ctBuReceiptInfo);
    }
}
