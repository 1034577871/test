package com.ruoyi.paymentManagement.ticketRecord.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.base.fileManage.domain.CtBuFile;
import com.ruoyi.base.fileManage.service.ICtBuFileService;
import com.ruoyi.collection.domain.CtBuInvoiceInfo;
import com.ruoyi.collection.utils.ActUtils;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.contract.contractInfo.domain.CtBuContract;
import com.ruoyi.contract.payinfoInvoice.domain.CtBuPayinfoInvoice;
import com.ruoyi.contract.payinfoInvoice.mapper.CtBuPayinfoInvoiceMapper;
import com.ruoyi.contract.payinfoInvoice.service.ICtBuPayinfoInvoiceService;
import com.ruoyi.system.service.ISysUserService;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.TaskService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.paymentManagement.ticketRecord.domain.TicketRecord;
import com.ruoyi.paymentManagement.ticketRecord.mapper.TicketRecordMapper;
import com.ruoyi.paymentManagement.ticketRecord.service.ITicketRecordService;


/**
 * 收票记录Service业务层处理
 *
 * @author lps
 * @date 2020-12-17
 */
@Service
public class TicketRecordServiceImpl implements ITicketRecordService {
    @Autowired
    private TicketRecordMapper ticketRecordMapper;

    @Autowired
    private ICtBuFileService fileService;

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRuntime taskRuntime;

    @Autowired
    private CtBuPayinfoInvoiceMapper ctBuPayinfoInvoiceMapper;


    /**
     * 查询收票记录
     *
     * @param id 收票记录ID
     * @return 收票记录
     */
    @Override
    public TicketRecord selectTicketRecordById(String id) {
        return ticketRecordMapper.selectTicketRecordById(id);
    }

    /**
     * 查询收票记录列表
     *
     * @param ticketRecord 收票记录
     * @return 收票记录
     */
    @Override
    public List<TicketRecord> selectTicketRecordList(TicketRecord ticketRecord) {
        return ticketRecordMapper.selectTicketRecordList(ticketRecord);
    }

    /**
     * 新增收票记录
     *
     * @param ticketRecord 收票记录
     * @return 结果
     */
    @Override
    public int insertTicketRecord(TicketRecord ticketRecord) {
        /** 判断当前登录人 **/
        LoginUser loginUser = SecurityUtils.getLoginUser();

        ticketRecord.setId(UUID.fastUUID().toString(true));
        String userId = "";
        try {
            userId = SecurityUtils.getLoginUser().getUser().getUserId().toString();
        } catch (Exception e) {

        }


        /** 处理文件 **/
        //发票凭证
        if (StringUtils.isNotBlank(ticketRecord.getInvoiceVoucher())) {
            String[] str = ticketRecord.getInvoiceVoucher().split(",");
            for (int i = 0; i < str.length; i++) {
                /** 判断传入文件ID是否为空 **/
                if (StringUtils.isNotBlank(str[i])) {
                    CtBuFile file = new CtBuFile();
                    file.setId(str[i]);
                    file.setPtype(1);   //发票凭证 ptype:1
                    file.setPid(ticketRecord.getId());
                    fileService.updateCtBuFile(file);
                }
            }
        }
        //对方单位资质
        if (StringUtils.isNotBlank(ticketRecord.getUnitQualification())) {
            String[] str = ticketRecord.getUnitQualification().split(",");
            for (int i = 0; i < str.length; i++) {
                /** 判断传入文件ID是否为空 **/
                if (StringUtils.isNotBlank(str[i])) {
                    CtBuFile file = new CtBuFile();
                    file.setId(str[i]);
                    file.setPtype(2);   //对方单位资质 ptype:2
                    file.setPid(ticketRecord.getId());
                    fileService.updateCtBuFile(file);
                }
            }
        }
        ticketRecord.setInvoiceVoucher(null);
        ticketRecord.setUnitQualification(null);
        ticketRecord.setCreateBy(userId);
        ticketRecord.setDelFlag("1");
        ticketRecord.setCreateTime(DateUtils.getNowDate());

        if (ticketRecord.getStatus() == 0) {
            ticketRecord.setStatusps("保存");
        } else if (ticketRecord.getStatus() == 1) {
            ticketRecord.setStatusps("审核中");
            //获取当前登陆人的所属部门
            long dept_id = loginUser.getUser().getDept().getDeptId();
            Map<String, Object> variables = this.getVarirs(loginUser);
            variables.put("apply", loginUser.getUsername());
            String widthName = "收票记录审核-" + loginUser.getUser().getNickName();
            String key = "ticket_record_audit";
            ticketRecord.setInstanceId(ActUtils.submitTask(processRuntime, loginUser, ticketRecord.getId(), variables
                    , taskService, taskRuntime, key, widthName));
        }

        //付款周期-发票对应关系表
        CtBuPayinfoInvoice ctBuPayinfoInvoice = new CtBuPayinfoInvoice();
        ctBuPayinfoInvoice.setId(UUID.fastUUID().toString(true));
        ctBuPayinfoInvoice.setContractId(ticketRecord.getContractId());
        ctBuPayinfoInvoice.setPaymentCycleId(ticketRecord.getPayinfoid());
        ctBuPayinfoInvoice.setBid(ticketRecord.getId());
        ctBuPayinfoInvoice.setInvoiceNo(ticketRecord.getInvoiceNo());
        ctBuPayinfoInvoice.setInvoiceCode(ticketRecord.getInvoiceCode());
        ctBuPayinfoInvoice.setInvoiceMoney(ticketRecord.getInvoiceMoney());
        ctBuPayinfoInvoice.setInvoiceNomoney(ticketRecord.getInvoiceNomoney());
        ctBuPayinfoInvoice.setInvoiceTime(ticketRecord.getInvoiceDate());
        ctBuPayinfoInvoice.setDelFlag(1);
        ctBuPayinfoInvoice.setRemark(ticketRecord.getRemark());
        ctBuPayinfoInvoice.setCreateBy(ticketRecord.getCreateBy());
        ctBuPayinfoInvoice.setCreateTime(ticketRecord.getCreateTime());
        ctBuPayinfoInvoiceMapper.insertCtBuPayinfoInvoice(ctBuPayinfoInvoice);


        return ticketRecordMapper.insertTicketRecord(ticketRecord);
    }

    /**
     * 修改收票记录
     *
     * @param ticketRecord 收票记录
     * @return 结果
     */
    @Override
    public int updateTicketRecord(TicketRecord ticketRecord) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (ticketRecord.getStatus() == 0) {
            ticketRecord.setStatusps("保存");
        } else if (ticketRecord.getStatus() == 1) {
            ticketRecord.setStatusps("审核中");
            //获取当前登陆人的所属部门
            long dept_id = loginUser.getUser().getDept().getDeptId();
            Map<String, Object> variables = this.getVarirs(loginUser);
            variables.put("apply", loginUser.getUsername());
            String widthName = "收票记录审核-" + loginUser.getUser().getNickName();
            String key = "ticket_record_audit";
            ticketRecord.setInstanceId(ActUtils.submitTask(processRuntime, loginUser, ticketRecord.getId(), variables
                    , taskService, taskRuntime, key, widthName));
        }
        /** 处理文件 **/
        //发票凭证
        if (StringUtils.isNotBlank(ticketRecord.getInvoiceVoucher())) {
            String[] str = ticketRecord.getInvoiceVoucher().split(",");
            for (int i = 0; i < str.length; i++) {
                /** 判断传入文件ID是否为空 **/
                if (StringUtils.isNotBlank(str[i])) {
                    CtBuFile file = new CtBuFile();
                    file.setId(str[i]);
                    file.setPtype(1);   //发票凭证 ptype:1
                    file.setPid(ticketRecord.getId());
                    fileService.updateCtBuFile(file);
                }
            }
        }
        //对方单位资质
        if (StringUtils.isNotBlank(ticketRecord.getUnitQualification())) {
            String[] str = ticketRecord.getUnitQualification().split(",");
            for (int i = 0; i < str.length; i++) {
                /** 判断传入文件ID是否为空 **/
                if (StringUtils.isNotBlank(str[i])) {
                    CtBuFile file = new CtBuFile();
                    file.setId(str[i]);
                    file.setPtype(2);   //对方单位资质 ptype:2
                    file.setPid(ticketRecord.getId());
                    fileService.updateCtBuFile(file);
                }
            }
        }
        ticketRecord.setInvoiceVoucher(null);
        ticketRecord.setUnitQualification(null);
        ticketRecord.setUpdateTime(DateUtils.getNowDate());
        ticketRecord.setUpdateBy(loginUser.getUser().getUserId().toString());

        //付款周期-发票对应关系表
        CtBuPayinfoInvoice ctBuPayinfoInvoice = ctBuPayinfoInvoiceMapper.selectCtBuPayinfoInvoiceByBid(ticketRecord.getId());

        if (ctBuPayinfoInvoice != null) {
            ctBuPayinfoInvoice.setContractId(ticketRecord.getContractId());
            ctBuPayinfoInvoice.setPaymentCycleId(ticketRecord.getPayinfoid());
            ctBuPayinfoInvoice.setBid(ticketRecord.getId());
            ctBuPayinfoInvoice.setInvoiceNo(ticketRecord.getInvoiceNo());
            ctBuPayinfoInvoice.setInvoiceCode(ticketRecord.getInvoiceCode());
            ctBuPayinfoInvoice.setInvoiceMoney(ticketRecord.getInvoiceMoney());
            ctBuPayinfoInvoice.setInvoiceNomoney(ticketRecord.getInvoiceNomoney());
            ctBuPayinfoInvoice.setInvoiceTime(ticketRecord.getInvoiceDate());
            ctBuPayinfoInvoice.setDelFlag(1);
            ctBuPayinfoInvoice.setRemark(ticketRecord.getRemark());
            ctBuPayinfoInvoice.setUpdateBy(ticketRecord.getUpdateBy());
            ctBuPayinfoInvoice.setUpdateTime(ticketRecord.getUpdateTime());
            ctBuPayinfoInvoiceMapper.updateCtBuPayinfoInvoice(ctBuPayinfoInvoice);
        }

        return ticketRecordMapper.updateTicketRecord(ticketRecord);
    }

    //获取组人员
    public Map<String, Object> getVarirs(LoginUser loginUser) {
        Map<String, Object> variables = new HashMap();
        List<String> ulist = new ArrayList();
        long dept_id = 100000;
        if ("2".equals(loginUser.getUser().getUserType())) {
            //分公司财务人员
            dept_id = loginUser.getUser().getDeptId();
            variables.put("fgsFinance", ActUtils.getVarirs(dept_id, "103", iSysUserService));
            variables.put("userType", 2);
        }
        if ("1".equals(loginUser.getUser().getUserType())) {
            dept_id = loginUser.getUser().getDeptId();
            variables.put("bbFinance", ActUtils.getVarirs(null, "105", iSysUserService));
            variables.put("userType", 1);
        }
        return variables;
    }

    /**
     * 批量删除收票记录
     *
     * @param ids 需要删除的收票记录ID
     * @return 结果
     */
    @Override
    public int deleteTicketRecordByIds(String[] ids) {
        return ticketRecordMapper.deleteTicketRecordByIds(ids);
    }

    /**
     * 批量逻辑删除收票记录
     *
     * @param ids 需要删除的收票记录ID
     * @return 结果
     */
    @Override
    public int updateTicketRecordByIds(String[] ids) {

        if (ids != null && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {
                int i1 = ticketRecordMapper.updateTicketRecordById(ids[i]);
                int i2 = ctBuPayinfoInvoiceMapper.updateCtBuPayinfoInvoiceByBid(ids[i]);
            }
        }
        return 1;
    }

    /**
     * 删除收票记录信息
     *
     * @param id 收票记录ID
     * @return 结果
     */
    @Override
    public int deleteTicketRecordById(String id) {
        return ticketRecordMapper.deleteTicketRecordById(id);
    }

    /**
     * 根据实例ID修改
     *
     * @param ticketRecord 收票记录
     * @return
     */
    @Override
    public int updateTicketRecordByInstanceId(TicketRecord ticketRecord) {
        return ticketRecordMapper.updateTicketRecordByInstanceId(ticketRecord);
    }

    /**
     * 根据实例ID查询
     *
     * @param instanceId
     * @return
     */
    @Override
    public TicketRecord selectTicketRecordByInstanceId(String instanceId) {
        return ticketRecordMapper.selectTicketRecordByInstanceId(instanceId);
    }


    /**
     * 查询收票记录列表
     *
     * @param ticketRecord 收票记录
     * @return 收票记录
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "u")
    public List<TicketRecord> selectTicketRecordList1(TicketRecord ticketRecord) {
        return ticketRecordMapper.selectTicketRecordList1(ticketRecord);
    }
}
