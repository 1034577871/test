package com.ruoyi.collection.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.json.JSONUtil;
import com.ruoyi.base.fileManage.domain.CtBuFile;
import com.ruoyi.base.fileManage.service.ICtBuFileService;
import com.ruoyi.collection.domain.ActWorkflowFormDatas;
import com.ruoyi.collection.utils.ActUtils;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.collection.domain.CtBuInvoiceReqDetail;
import com.ruoyi.collection.domain.CtBuInvoiceReqDto;
import com.ruoyi.collection.mapper.CtBuInvoiceReqDetailMapper;
import com.ruoyi.contract.contractInfo.domain.CtBuContract;
import com.ruoyi.contract.contractInfo.service.ICtBuContractService;
import com.ruoyi.contract.contractPayinfo.domain.CtBuContractPayinfo;
import com.ruoyi.mq.bean.SysConstant;
import com.ruoyi.mq.service.MsgService;
import com.ruoyi.projectApproval.ApprovalNg.domain.CtBuApprovalNg;
import com.ruoyi.projectApproval.ApprovalNg.mapper.CtBuApprovalNgMapper;
import com.ruoyi.system.service.ISysUserService;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.collection.mapper.CtBuInvoiceReqMapper;
import com.ruoyi.collection.domain.CtBuInvoiceReq;
import com.ruoyi.collection.service.ICtBuInvoiceReqService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 发票申请Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-09
 */

@Service
public class CtBuInvoiceReqServiceImpl implements ICtBuInvoiceReqService 
{
    @Autowired
    private CtBuInvoiceReqMapper ctBuInvoiceReqMapper;

    @Autowired
    private CtBuInvoiceReqDetailMapper ctBuInvoiceReqDetailMapper;

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
    private ICtBuFileService fileService;

    @Autowired
    private MsgService msgService;

    @Autowired
    private  ICtBuContractService iCtBuContractService;

    //收付款列表
    @Override
    public List<com.ruoyi.contract.contractPayinfo.domain.CtBuContractPayinfo> selectContractPayinfoById(com.ruoyi.contract.contractPayinfo.domain.CtBuContractPayinfo info){

        return ctBuInvoiceReqMapper.selectContractPayinfoById(info);
    }

    @Override
    public CtBuApprovalNg getApproNgByid(String id){
        CtBuApprovalNg ctBuApprovalNg = ctBuApprovalNgMapper.selectCtBuApprovalNgById(id);
        return ctBuApprovalNg;
    }
    /**
     * 获取当前用户信息
     *
     * @param  发票申请
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public LoginUser getUserInfo() {
        /** 判断当前登录人 **/
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //loginUser.getUser().getDept().getDeptId()
        return loginUser;
    }

    /**
     * 获取当前用户信息
     *
     * @param  发票申请
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map getUserInfoCon(String id) {
        /** 判断当前登录人 **/
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //loginUser.getUser().getDept().getDeptId()
        CtBuContract ctBuContract = iCtBuContractService.selectCtBuContractById(id);
        Map map = new HashMap();
        map.put("user",loginUser);
        map.put("contract",ctBuContract);
        return map;
    }

    /**
     * 查询发票申请
     * 
     * @param id 发票申请ID
     * @return 发票申请
     */
    @Override
    public CtBuInvoiceReqDto selectCtBuInvoiceReqById(String id)
    {
        CtBuInvoiceReqDto dto = ctBuInvoiceReqMapper.selectCtBuInvoiceReqDtoById(id);
        CtBuInvoiceReq req = ctBuInvoiceReqMapper.selectCtBuInvoiceReqById(id);
        if(req!=null && req.getId()!=null){
            CtBuInvoiceReqDetail detail = new CtBuInvoiceReqDetail();
            detail.setInvoiceId(req.getId());
           List<CtBuInvoiceReqDetail> list =  ctBuInvoiceReqDetailMapper.selectCtBuInvoiceReqDetailList(detail);
            dto.setCtBuInvoiceReqDetail(list);
            ActWorkflowFormDatas data = new ActWorkflowFormDatas();
            data.setBusinessKey(req.getId());
            List<ActWorkflowFormDatas> alist = ctBuInvoiceReqMapper.selectGroupActWorkflowFormDataLists(data);
            dto.setActWorkflowFormData(alist);
        }
        //获取收款信息
        CtBuContractPayinfo info = new CtBuContractPayinfo();
        info.setContractId(dto.getContractId());
        List<CtBuContractPayinfo> list = ctBuInvoiceReqMapper.selectContractPayinfoById(info);
        dto.setCtBuContractPayinfos(list);
        return dto;
    }

    /**
     * 查询已办详情
     *
     * @param id 发票申请ID
     * @return 发票申请
     */
    @Override
    public CtBuInvoiceReqDto selectCtBuInvoiceReqByInstanceId(String id)
    {
        CtBuInvoiceReqDto dto = ctBuInvoiceReqMapper.selectCtBuInvoiceReqDtoByInstanceId(id);
        CtBuInvoiceReq req = ctBuInvoiceReqMapper.selectCtBuInvoiceReqById(dto.getId());
        if(req!=null && req.getId()!=null){
            CtBuInvoiceReqDetail detail = new CtBuInvoiceReqDetail();
            detail.setInvoiceId(req.getId());
            List<CtBuInvoiceReqDetail> list =  ctBuInvoiceReqDetailMapper.selectCtBuInvoiceReqDetailList(detail);
            dto.setCtBuInvoiceReqDetail(list);
            ActWorkflowFormDatas data = new ActWorkflowFormDatas();
            data.setBusinessKey(req.getId());
            List<ActWorkflowFormDatas> alist = ctBuInvoiceReqMapper.selectGroupActWorkflowFormDataLists(data);
            dto.setActWorkflowFormData(alist);
        }
        return dto;
    }
    /**
     * 查询发票申请列表
     * 
     * @param ctBuInvoiceReq 发票申请
     * @return 发票申请
     */
    @DataScope(deptAlias = "U",userAlias = "D")
    @Override
    public List<CtBuInvoiceReq> selectCtBuInvoiceReqList(CtBuInvoiceReq ctBuInvoiceReq)
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (loginUser != null && loginUser.getUser() != null) {
            ctBuInvoiceReq.setCreateBy(loginUser.getUser().getUserId().toString());
        }
        return ctBuInvoiceReqMapper.selectCtBuInvoiceReqList(ctBuInvoiceReq);
    }

    /**
     * 新增发票申请
     *
     * @param ctBuInvoiceReq 发票申请
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertCtBuInvoiceReq(CtBuInvoiceReqDto ctBuInvoiceReq)
    {
        String uuid = UUID.fastUUID().toString(true);
        ctBuInvoiceReq.setCreateTime(DateUtils.getNowDate());
        ctBuInvoiceReq.setId(uuid);
        ctBuInvoiceReq.setDelFlag("1");
        /** 判断当前登录人 **/
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (loginUser != null && loginUser.getUser() != null) {
            ctBuInvoiceReq.setCreateBy(loginUser.getUser().getUserId().toString());
            ctBuInvoiceReq.setCreateByName(loginUser.getUser().getNickName());
        }
        String widthName ="";
        //实列
        if("1".equals(ctBuInvoiceReq.getState()) &&  ctBuInvoiceReq.getStatus()!=2){
            //获取当前登陆人的所属部门
            long dept_id = loginUser.getUser().getDept().getDeptId();
            Map<String, Object> variables = this.getVarirs(loginUser);
            variables.put("apply",loginUser.getUsername());
             widthName = "发票申请-"+loginUser.getUser().getNickName();
            String key ="invoiceApply";
            ctBuInvoiceReq.setInstanceId(ActUtils.submitTask(processRuntime,loginUser,ctBuInvoiceReq.getId(),variables
                    ,taskService,taskRuntime,key,widthName));
            ctBuInvoiceReq.setState(ctBuInvoiceReq.getState());
        }
        ctBuInvoiceReq.setStatus(Integer.parseInt(ctBuInvoiceReq.getState()));

        /** 处理文件 **/
        if (org.apache.commons.lang3.StringUtils.isNotBlank(ctBuInvoiceReq.getRecord())) {
            String[] str = ctBuInvoiceReq.getRecord().split(",");
            for (int i = 0; i < str.length; i++) {
                /** 判断传入文件ID是否为空 **/
                if (StringUtils.isNotBlank(str[i])) {
                    CtBuFile file = new CtBuFile();
                    file.setId(str[i]);
                    file.setPtype(1);   //合同归档资料 ptype:1
                    file.setPid(ctBuInvoiceReq.getId());
                    fileService.updateCtBuFile(file);
                }
            }
        }
        if (org.apache.commons.lang3.StringUtils.isNotBlank(ctBuInvoiceReq.getZmcl())) {
            String[] str = ctBuInvoiceReq.getZmcl().split(",");
            for (int i = 0; i < str.length; i++) {
                /** 判断传入文件ID是否为空 **/
                if (StringUtils.isNotBlank(str[i])) {
                    CtBuFile file = new CtBuFile();
                    file.setId(str[i]);
                    file.setPtype(2);   //合同归档资料 ptype:1
                    file.setPid(ctBuInvoiceReq.getId());
                    fileService.updateCtBuFile(file);
                }
            }
        }
//        if("1".equals(ctBuInvoiceReq.getIfysk())){
//            ctBuInvoiceReq.setDelFlag("2");
//        }
        int num = ctBuInvoiceReqMapper.insertCtBuInvoiceReq(ctBuInvoiceReq);
        if(num>0){
            if("1".equals(ctBuInvoiceReq.getState())){
                    // 根据流程实例Id查询任务
                    Map map = new HashMap();
                    map.put("instanceId",ctBuInvoiceReq.getInstanceId());
                    map.put("name",widthName);
                    msgService.sendDelayMsgToMQ(SysConstant.SYS_NG_EXCHANGE,SysConstant.SYS_NG_KEY, JSONUtil.toJsonStr(map),0);//30秒钟后执行
            }
            //添加字表
            if(ctBuInvoiceReq.getCtBuInvoiceReqDetail()!=null && ctBuInvoiceReq.getCtBuInvoiceReqDetail().size()>0){
                for (CtBuInvoiceReqDetail detail:ctBuInvoiceReq.getCtBuInvoiceReqDetail()) {
                    detail.setId(UUID.fastUUID().toString(true));
                    detail.setInvoiceId(uuid);
                    detail.setInvoiceProName(detail.getInvoiceProName());
                    detail.setInvoiceSpec(detail.getInvoiceSpec());
                    detail.setInvoiceType(detail.getInvoiceType());
                    //detail.setUnit(ctBuInvoiceReq.getUnit());
                    detail.setInvoicePrice(detail.getInvoicePrice());
                    detail.setInvoiceMount(detail.getInvoiceMount());
                    detail.setInvoiceMount(detail.getInvoiceMount());
                    detail.setInvoiceAmountTax(detail.getInvoiceAmountTax());
                    detail.setInvoiceAmountNtax(detail.getInvoiceAmountNtax());
                    detail.setInvoiceTaxrate(detail.getInvoiceTaxrate());
                    if (loginUser != null && loginUser.getUser() != null) {
                        detail.setCreateBy(loginUser.getUser().getUserId().toString());
                    }
                    detail.setDelFlag("1");
                    detail.setCreateTime(DateUtils.getNowDate());
                    ctBuInvoiceReqDetailMapper.insertCtBuInvoiceReqDetail(detail);
                }
            }

        }
        return num;
    }

    //获取组人员
    public Map<String,Object>  getVarirs(LoginUser loginUser){
        Map<String,Object> variables = new HashMap();
        List<String> ulist = new ArrayList();
        Map params = new HashMap();
        long dept_id =100000;

        if("2".equals(loginUser.getUser().getUserType())){
            variables.put("userstate",2);
            //分公司财务人员
            dept_id = loginUser.getUser().getDeptId();
            variables.put("fcwgroup", ActUtils.getVarirs(dept_id,"103",iSysUserService));
            //分公司管理人员
            variables.put("fgsgroup", ActUtils.getVarirs(dept_id,"110",iSysUserService));
        }
        if("1".equals(loginUser.getUser().getUserType())){
            variables.put("userstate",1);
        }

        //本公司财务
        variables.put("bcwgroup", ActUtils.getVarirs(null,"105",iSysUserService));
        return variables;
    }

    /**
     * 修改发票申请
     * 
     * @param ctBuInvoiceReq 发票申请
     * @return 结果
     */
    @Override
    public int updateCtBuInvoiceReq(CtBuInvoiceReqDto ctBuInvoiceReq)
    {
        ctBuInvoiceReq.setUpdateTime(DateUtils.getNowDate());
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (loginUser != null && loginUser.getUser() != null) {
            ctBuInvoiceReq.setUpdateBy(loginUser.getUser().getUserId().toString());
        }
        //实列
        String widthName ="";
        if("1".equals(ctBuInvoiceReq.getState()) && ctBuInvoiceReq.getStatus()!=2){
            long dept_id = loginUser.getUser().getDept().getDeptId();
            Map<String, Object> variables = this.getVarirs(loginUser);
            variables.put("apply",loginUser.getUsername());
             widthName = "发票申请-"+loginUser.getUser().getNickName();
            String key ="invoiceApply";
            ctBuInvoiceReq.setInstanceId(ActUtils.submitTask(processRuntime,loginUser,ctBuInvoiceReq.getId(),variables
                    ,taskService,taskRuntime,key,widthName));
            ctBuInvoiceReq.setState(ctBuInvoiceReq.getState());
        }
        ctBuInvoiceReq.setStatus(Integer.parseInt(ctBuInvoiceReq.getState()));

        /** 处理文件 **/
        if (org.apache.commons.lang3.StringUtils.isNotBlank(ctBuInvoiceReq.getRecord())) {
            String[] str = ctBuInvoiceReq.getRecord().split(",");
            for (int i = 0; i < str.length; i++) {
                /** 判断传入文件ID是否为空 **/
                if (StringUtils.isNotBlank(str[i])) {
                    CtBuFile file = new CtBuFile();
                    file.setId(str[i]);
                    file.setPtype(1);   //合同归档资料 ptype:1
                    file.setPid(ctBuInvoiceReq.getId());
                    fileService.updateCtBuFile(file);
                }
            }
        }
        if (org.apache.commons.lang3.StringUtils.isNotBlank(ctBuInvoiceReq.getZmcl())) {
            String[] str = ctBuInvoiceReq.getZmcl().split(",");
            for (int i = 0; i < str.length; i++) {
                /** 判断传入文件ID是否为空 **/
                if (StringUtils.isNotBlank(str[i])) {
                    CtBuFile file = new CtBuFile();
                    file.setId(str[i]);
                    file.setPtype(2);   //合同归档资料 ptype:1
                    file.setPid(ctBuInvoiceReq.getId());
                    fileService.updateCtBuFile(file);
                }
            }
        }
//        if("1".equals(ctBuInvoiceReq.getIfysk())){
//            ctBuInvoiceReq.setDelFlag("2");
//        }
        int num = ctBuInvoiceReqMapper.updateCtBuInvoiceReq(ctBuInvoiceReq);
        if(num>0){
            if("1".equals(ctBuInvoiceReq.getState())){
                // 根据流程实例Id查询任务
                Map map = new HashMap();
                map.put("instanceId",ctBuInvoiceReq.getInstanceId());
                map.put("name",widthName);
                msgService.sendDelayMsgToMQ(SysConstant.SYS_NG_EXCHANGE,SysConstant.SYS_NG_KEY, JSONUtil.toJsonStr(map),0);//30秒钟后执行
            }
            //添加字表
            if(ctBuInvoiceReq.getCtBuInvoiceReqDetail()!=null && ctBuInvoiceReq.getCtBuInvoiceReqDetail().size()>0){
                for (CtBuInvoiceReqDetail detail:ctBuInvoiceReq.getCtBuInvoiceReqDetail()) {
                    detail.setId(detail.getId());
                    detail.setInvoiceId(ctBuInvoiceReq.getId());
                    detail.setInvoiceProName(detail.getInvoiceProName());
                    detail.setInvoiceSpec(detail.getInvoiceSpec());
                    detail.setInvoiceType(detail.getInvoiceType());
                    //detail.setUnit(ctBuInvoiceReq.getUnit());
                    detail.setInvoicePrice(detail.getInvoicePrice());
                    detail.setInvoiceMount(detail.getInvoiceMount());
                    detail.setInvoiceMount(detail.getInvoiceMount());
                    detail.setInvoiceAmountTax(detail.getInvoiceAmountTax());
                    detail.setInvoiceAmountNtax(detail.getInvoiceAmountNtax());
                    detail.setInvoiceTaxrate(detail.getInvoiceTaxrate());
                    if (loginUser != null && loginUser.getUser() != null) {
                        detail.setCreateBy(loginUser.getUser().getUserId().toString());
                    }
                    detail.setDelFlag("1");
                    detail.setCreateTime(DateUtils.getNowDate());
                    if(detail.getId()==null || "".equals(detail.getId())){
                        detail.setId(UUID.fastUUID().toString(true));
                        ctBuInvoiceReqDetailMapper.insertCtBuInvoiceReqDetail(detail);
                    }else{
                        ctBuInvoiceReqDetailMapper.updateCtBuInvoiceReqDetailById(detail);
                    }
                }
            }
        }
        return num;
    }


    /**
     * 修改发票申请状态
     *
     * @param ctBuInvoiceReq 发票申请
     * @return 结果
     */
    @Override
    public int updatesCtBuInvoiceReq(CtBuInvoiceReqDto ctBuInvoiceReq)
    {
        int num = ctBuInvoiceReqMapper.updateCtBuInvoiceReqByInstanceId(ctBuInvoiceReq);
        return num;
    }
    /**
     * id修改发票
     *
     * @param ctBuInvoiceReq 发票申请
     * @return 结果
     */
    @Override
    public int updatesCtBuInvoiceReqByid(CtBuInvoiceReqDto ctBuInvoiceReq)
    {

        int num = ctBuInvoiceReqMapper.updateCtBuInvoiceReq(ctBuInvoiceReq);
        return num;
    }
    /**
     * 批量删除发票申请
     * 
     * @param ids 需要删除的发票申请ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteCtBuInvoiceReqByIds(String[] ids)
    {
        int num = ctBuInvoiceReqMapper.deleteCtBuInvoiceReqByIds(ids);
        if(num>0){
            ctBuInvoiceReqDetailMapper.deleteCtBuInvoiceReqDetailByIds(ids);
        }
        return num;
    }

    /**
     * 新增发票审核记录
     *
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int  insertSubActWorkflowFormData(Map map) {
       return  this.ctBuInvoiceReqMapper.insertSubActWorkflowFormData(map);
    }
    /**
     * 删除发票申请信息
     * 
     * @param id 发票申请ID
     * @return 结果
     */
    @Override
    public int deleteCtBuInvoiceReqById(String id)
    {
        return ctBuInvoiceReqMapper.deleteCtBuInvoiceReqById(id);
    }
}
