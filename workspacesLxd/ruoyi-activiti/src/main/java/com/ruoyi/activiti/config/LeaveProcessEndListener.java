package com.ruoyi.activiti.config;

import com.ruoyi.collection.domain.CtBuInvoiceReq;
import com.ruoyi.collection.domain.CtBuInvoiceReqDto;
import com.ruoyi.collection.service.ICtBuInvoiceReqService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.persistence.entity.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author: Henry Yan
 */
@Service
@Transactional
public class LeaveProcessEndListener implements ExecutionListener {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ICtBuInvoiceReqService iCtBuInvoiceReqService;

    @Override
    public void notify(DelegateExecution execution) {
        //流程正常结束
        String processInstanceId = execution.getProcessInstanceId();
        CtBuInvoiceReqDto req = new CtBuInvoiceReqDto();
        req.setInstanceId(processInstanceId);
        req.setStatus(2);
        iCtBuInvoiceReqService.updatesCtBuInvoiceReq(req);
        logger.debug("清理了 {} 条历史表单数据");
    }
}
