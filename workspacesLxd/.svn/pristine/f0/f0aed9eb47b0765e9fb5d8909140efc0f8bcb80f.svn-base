package com.ruoyi.activiti.config;

import com.ruoyi.projectApproval.AppNgc.domain.AppNgc;
import com.ruoyi.projectApproval.AppNgc.service.IAppNgcService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
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
public class FjkUpProcessEndListener implements ExecutionListener {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IAppNgcService iAppNgcService;


    @Override
    public void notify(DelegateExecution execution) {
        //流程正常结束
        String processInstanceId = execution.getProcessInstanceId();
        AppNgc req = new AppNgc();
        req.setInstanceId(processInstanceId);
        req.setStatus(2);
        req.setStatusPs("审核通过");
        iAppNgcService.updateAppNgcByInstanceId(req);
    }
}
