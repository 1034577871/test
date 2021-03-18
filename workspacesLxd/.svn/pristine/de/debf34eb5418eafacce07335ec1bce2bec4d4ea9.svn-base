package com.ruoyi.activiti.config;

import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.contract.contractInfo.domain.CtBuContract;
import com.ruoyi.contract.contractInfo.mapper.CtBuContractMapper;
import com.ruoyi.contract.contractInfo.service.ICtBuContractService;
import com.ruoyi.contract.payinfoInvoice.domain.CtBuPayinfoInvoice;
import com.ruoyi.contract.payinfoInvoice.service.ICtBuPayinfoInvoiceService;
import com.ruoyi.paymentManagement.ticketRecord.domain.TicketRecord;
import com.ruoyi.paymentManagement.ticketRecord.service.ITicketRecordService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


/**
 * 请假流程结束监听器
 *
 * @author: Henry Yan
 */
@Service
@Transactional
public class TicketRecordAuditEnd implements ExecutionListener {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ITicketRecordService iTicketRecordService;


    
    @Autowired
    private CtBuContractMapper ctBuContractMapper;

    @Override
    public void notify(DelegateExecution execution) {
        //流程正常结束
        String processInstanceId = execution.getProcessInstanceId();
        TicketRecord ticketRecord = new TicketRecord();
        ticketRecord.setInstanceId(processInstanceId);
        ticketRecord.setStatus(2L);
        ticketRecord.setStatusps("审核通过");
        iTicketRecordService.updateTicketRecordByInstanceId(ticketRecord);
        TicketRecord ticketRecord1 = iTicketRecordService.selectTicketRecordByInstanceId(processInstanceId);




        logger.debug("清理了 {} 条历史表单数据");
    }
}
