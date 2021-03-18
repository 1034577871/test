package com.ruoyi.leave.instener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.Expression;

import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.leave.domain.WorkflowLeave;
import com.ruoyi.leave.service.IWorkflowLeaveService;

public class LeaveEndStateListener implements ExecutionListener {

	private static final long serialVersionUID = 99661L;
	
	private Expression state;

	@Override
	public void notify(DelegateExecution delegateExecution) {
		WorkflowLeave workflowLeave = new WorkflowLeave();
		workflowLeave.setId(delegateExecution.getProcessInstanceBusinessKey());
		workflowLeave.setState(state.getValue(delegateExecution).toString());
		SpringUtils.getBean(IWorkflowLeaveService.class).updateWorkflowLeave(workflowLeave);
	}
}
