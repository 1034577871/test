package com.ruoyi.activiti.config;

import com.ruoyi.activiti.mapper.PublicMapper;
import com.ruoyi.contract.contractInfo.service.ICtBuContractService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 三重一大业务流程结束监听器
 *
 * @author: Henry Yan
 */
@Service
@Transactional
public class ImportantProjectEnd implements ExecutionListener {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ICtBuContractService iCtBuContractService;
    @Autowired
    private PublicMapper publicMapper;

    @Override
    public void notify(DelegateExecution execution) {
        //流程正常结束
        String processInstanceId = execution.getProcessInstanceId();
        publicMapper.updateColumnBy("ct_bu_approval_ng","status",2,"instance_id",processInstanceId);
        publicMapper.updateColumnBy("ct_bu_approval_ng","status_ps","审核通过","instance_id",processInstanceId);
        logger.debug("清理了 {} 条历史表单数据");
    }
}
