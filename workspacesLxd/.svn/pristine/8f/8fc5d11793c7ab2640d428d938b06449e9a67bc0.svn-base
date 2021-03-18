package com.ruoyi.activiti.config;

import com.ruoyi.contract.contractInfo.domain.CtBuContract;
import com.ruoyi.contract.contractInfo.service.ICtBuContractService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 请假流程结束监听器
 *
 * @author: Henry Yan
 */
@Service
@Transactional
public class ContractAuditEnd implements ExecutionListener {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ICtBuContractService iCtBuContractService;

    @Override
    public void notify(DelegateExecution execution) {
        //流程正常结束
        String processInstanceId = execution.getProcessInstanceId();
        CtBuContract ctBuContract = new CtBuContract();
        ctBuContract.setInstanceId(processInstanceId);
        ctBuContract.setStatus(2);
        ctBuContract.setStatusPs("审核通过");
        iCtBuContractService.updateCtBuContractByInstanceId(ctBuContract);
        logger.debug("清理了 {} 条历史表单数据");
    }
}
