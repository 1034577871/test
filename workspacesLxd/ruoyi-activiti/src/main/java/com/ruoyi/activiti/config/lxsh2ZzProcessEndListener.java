package com.ruoyi.activiti.config;

import com.ruoyi.projectApproval.ApprovalNg.domain.CtBuApprovalNg;
import com.ruoyi.projectApproval.ApprovalNg.service.ICtBuApprovalNgService;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.runtime.ExecutionQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author: Henry Yan
 */
@Component
public class lxsh2ZzProcessEndListener implements TaskListener, ExecutionListener {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private static RuntimeService runtimeService;
    private static RepositoryService repositoryService;
    @Autowired
    public void setRuntimeService(RuntimeService runtimeService){
        this.runtimeService=runtimeService;
    }
    @Autowired
    public void setRepositoryService(RepositoryService repositoryService){
        this.repositoryService=repositoryService;
    }

    @Autowired
    public void setiCtBuApprovalNgService(ICtBuApprovalNgService iCtBuApprovalNgService) {
        this.iCtBuApprovalNgService = iCtBuApprovalNgService;
    }


    private static ICtBuApprovalNgService iCtBuApprovalNgService;
    @Override
    public void notify(DelegateTask delegateTask) {

        //获取当前的执行实例
        ExecutionQuery executionQuery =runtimeService.createExecutionQuery();
        ExecutionEntity executionEntity = (ExecutionEntity)executionQuery.executionId(delegateTask.getExecutionId()).singleResult();
        String activityId=executionEntity.getActivityId();
        //获取当前活动节点信息
        FlowNode flowNode=getFlowNode(delegateTask.getProcessDefinitionId(),activityId);

        //获取当前审批人的审批意向
        //获取流程id
        String exId = delegateTask.getExecutionId();
        String processInstanceId = delegateTask.getProcessInstanceId();
        //修改业务表状态
        //流程正常结束
        CtBuApprovalNg req = new CtBuApprovalNg();
        req.setInstanceId(processInstanceId);
        req.setStatus(3);
        req.setStatusPs("审核退回");
        iCtBuApprovalNgService.updateCtBuApprovalNgByInstanceId(req);


    }

    //获取当前节点的节点信息
    private FlowNode getFlowNode(String processDefinitionId, String activityId){
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);
        FlowNode flowNode = (FlowNode) bpmnModel.getMainProcess().getFlowElement(activityId);
        return flowNode;
    }


    @Override
    public void notify(DelegateExecution execution) {
        execution.getCurrentFlowElement();
    }


}
