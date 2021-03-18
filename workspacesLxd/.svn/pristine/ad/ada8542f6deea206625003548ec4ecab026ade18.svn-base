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
public class lxsh3fgfzProcessEndListener implements TaskListener, ExecutionListener {

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
        boolean pass=(boolean) delegateTask.getVariable("pass");
        //处理并行网关的多实例
        if(pass == false){
            //会签结束，设置参数result为N，下个任务为申请
            runtimeService.setVariable(exId, "fgfzshstate", 1);
            //下个任务
            String processInstanceId = delegateTask.getProcessInstanceId();
            //修改业务表状态
            //流程正常结束
            CtBuApprovalNg req = new CtBuApprovalNg();
            req.setInstanceId(processInstanceId);
            req.setStatus(3);
            req.setStatusPs("审核退回");
            iCtBuApprovalNgService.updateCtBuApprovalNgByInstanceId(req);

        }else{
            Integer complete = (Integer) runtimeService.getVariable(exId, "nrOfCompletedInstances");
            Integer all = (Integer) runtimeService.getVariable(exId, "nrOfInstances");
            //说明都完成了并且没有人拒绝
            if((complete + 1) / all == 1){
                runtimeService.setVariable(exId, "fgfzshstate", 0);
                //下个任务
                String processInstanceId = delegateTask.getProcessInstanceId();
//                Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
//                System.out.println("下个任务编码：" + task.getId() + "，下个任务名称：" + task.getName());
            }
        }

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
