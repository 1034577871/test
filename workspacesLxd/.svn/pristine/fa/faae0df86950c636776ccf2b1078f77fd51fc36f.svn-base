package com.ruoyi.activiti.utils;

import com.fasterxml.jackson.databind.node.ArrayNode;
import de.odysseus.el.ExpressionFactoryImpl;
import de.odysseus.el.util.SimpleContext;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.*;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.deploy.ProcessDefinitionCacheEntry;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ExecutionQuery;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * Activiti工具类
 *
 * @author zp
 */
@Component
public class ActivitiUtil {
    private static Logger logger = LoggerFactory.getLogger(ActivitiUtil.class);

    /**
     * 流程定义相关操作
     */
    @Autowired
    private ProcessRuntime processRuntime;

    /**
     * 任务相关操作
     */
    @Autowired
    private TaskRuntime taskRuntime;


    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private RuntimeService runtimeService;

    private static ActivitiUtil activitiUtil;


    /**
     * 获取当前任务节点的下一个任务节点
     *
     * @param task 当前任务节点
     * @return 下个任务节点
     * @throws Exception
     */
    public static List<String> getNextUserFlowElement(org.activiti.api.task.model.Task task) {
        // 取得已提交的任务
        HistoricTaskInstance historicTaskInstance = activitiUtil.historyService.createHistoricTaskInstanceQuery()
                .taskId(task.getId()).singleResult();

        // 获得流程定义
        ProcessDefinition processDefinition = activitiUtil.repositoryService.getProcessDefinition(historicTaskInstance.getProcessDefinitionId());

        //获得当前流程的活动ID
        ExecutionQuery executionQuery = activitiUtil.runtimeService.createExecutionQuery();
        Execution execution = executionQuery.executionId(historicTaskInstance.getExecutionId()).singleResult();
        String activityId = execution.getActivityId();
        UserTask userTask = null;
        List<String> list = null;
        while (true) {
            //根据活动节点获取当前的组件信息
            FlowNode flowNode = getFlowNode(processDefinition.getId(), activityId);
            //获取该节点之后的流向
            List<SequenceFlow> sequenceFlowListOutGoing = flowNode.getOutgoingFlows();

            // 获取的下个节点不一定是userTask的任务节点，所以要判断是否是任务节点
            if (sequenceFlowListOutGoing.size() > 1) {
                // 如果有1条以上的出线，表示有分支，需要判断分支的条件才能知道走哪个分支
                // 遍历节点的出线得到下个activityId
                list = getNextActivityId(execution.getId(),
                        task.getProcessInstanceId(), sequenceFlowListOutGoing);
            } else if (sequenceFlowListOutGoing.size() == 1) {
                // 只有1条出线,直接取得下个节点
                SequenceFlow sequenceFlow = sequenceFlowListOutGoing.get(0);
                // 下个节点
                FlowElement flowElement = sequenceFlow.getTargetFlowElement();
                if (flowElement instanceof UserTask) {
                    // 下个节点为UserTask时
                    userTask = (UserTask) flowElement;
                    System.out.println("下个任务为:" + userTask.getName());
                    activityId = userTask.getAssignee();
                } else if (flowElement instanceof ExclusiveGateway) {
                    // 下个节点为排它网关时
                    ExclusiveGateway exclusiveGateway = (ExclusiveGateway) flowElement;
                    List<SequenceFlow> outgoingFlows = exclusiveGateway.getOutgoingFlows();
                    // 遍历网关的出线得到下个activityId
                    list = getNextActivityId(execution.getId(), task.getProcessInstanceId(), outgoingFlows);
                }
                return list;
            } else {
                // 没有出线，则表明是结束节点
                return null;
            }
        }

    }
    /**
     * 根据活动节点和流程定义ID获取该活动节点的组件信息
     */
    public static FlowNode getFlowNode(String processDefinitionId, String flowElementId) {
        BpmnModel bpmnModel = activitiUtil.repositoryService.getBpmnModel(processDefinitionId);
        FlowNode flowNode = (FlowNode) bpmnModel.getMainProcess().getFlowElement(flowElementId);
        return flowNode;
    }
    /**
     * 根据el表达式取得满足条件的下一个activityId
     * @param executionId
     * @param processInstanceId
     * @param outgoingFlows
     * @return
     */
    public static List<String> getNextActivityId(String executionId,
                                           String processInstanceId,
                                           List<SequenceFlow> outgoingFlows) {
        String activityId = "";
        List<String> list = new ArrayList<>();
        // 遍历出线
        for (SequenceFlow outgoingFlow : outgoingFlows) {
            // 取得线上的条件
            String conditionExpression = outgoingFlow.getTargetRef();
            // 取得所有变量
            Map<String, Object> variables = activitiUtil.runtimeService.getVariables(executionId);
            String variableName = "";
            // 判断网关条件里是否包含变量名
            for (String s : variables.keySet()) {
                if (s.contains(conditionExpression) || conditionExpression.contains(s)) {
                    // 找到网关条件里的变量名
                    if(variables.get(s) instanceof  ArrayNode){
                        ArrayNode node = (ArrayNode)variables.get(s);
                        for(int i=0;i<node.size();i++){
                            list.add(node.get(i).textValue());
                        }
                    }
                    if(variables.get(s) instanceof  String){
                        activityId = (String)variables.get(s)+",";
                        String str = (String)variables.get(s);
                        if(!StringUtils.isEmpty(str)){
                            if(str.indexOf(",")!=-1){
                                String[] strs = str.split(",");
                                for(int i=0;i<strs.length;i++){
                                    list.add(strs[i]);
                                }
                            }else{
                                list.add(str);

                            }
                        }
                    }
                }
            }
//            String conditionVal = getVariableValue(variableName, processInstanceId);
//            // 判断el表达式是否成立
//            if (isCondition(variableName, conditionExpression, conditionVal)) {
//                // 取得目标节点
//                FlowElement targetFlowElement = outgoingFlow.getTargetFlowElement();
//                activityId = targetFlowElement.getId();
//                continue;
//            }
        }
        return list;
    }
    /**
     * 根据key和value判断el表达式是否通过
     *
     * @param key   el表达式key
     * @param el    el表达式
     * @param value el表达式传入值
     * @return
     */
    public static boolean isCondition(String key, String el, String value) {
        ExpressionFactory factory = new ExpressionFactoryImpl();
        SimpleContext context = new SimpleContext();
        context.setVariable(key, factory.createValueExpression(value, String.class));
        ValueExpression e = factory.createValueExpression(context, el, boolean.class);
        return (Boolean) e.getValue(context);
    }
    /**
     * 取得流程变量的值
     *
     * @param variableName      变量名
     * @param processInstanceId 流程实例Id
     * @return
     */
    public static String getVariableValue(String variableName, String processInstanceId) {
        Execution execution = activitiUtil.runtimeService
                .createExecutionQuery().processInstanceId(processInstanceId).list().get(0);
        Object object = activitiUtil.runtimeService.getVariable(execution.getId(), variableName);
        return object == null ? "" : object.toString();
    }
    public static org.activiti.engine.task.Task getTask(String taskId) {
        org.activiti.engine.task.Task task = activitiUtil.taskService.createTaskQuery().taskId(taskId).singleResult();
        return task;
    }

    @PostConstruct
    public void init() {
        // processRuntime等为static时无法注入，必须用activitiUtil.processRuntime形式
        activitiUtil = this;
    }


    /**
     * 取得当前节点的状态（已完成/进行中/未开始）
     *
     * @param flowElement
     * @return
     */
    public static String getFlowElementStatus(FlowElement flowElement, String executionId) {
        Activity activity = (Activity) flowElement;
        MultiInstanceLoopCharacteristics loopCharacteristics = activity.getLoopCharacteristics();
        if (loopCharacteristics == null) {
            // 节点为单实例的场合
            UserTask userTask = (UserTask) flowElement;
//            getTaskStatus();
        } else {
            // 节点为多实例的场合
            // 获取完成任务实例数量
            Integer nrOfCompletedInstances = (Integer) activitiUtil.runtimeService.getVariable(executionId, "nrOfCompletedInstances");
            // 获取会签总实例数量
            Integer numberOfInstances = (Integer) activitiUtil.runtimeService.getVariable(executionId, "numberOfInstances");

            if(nrOfCompletedInstances.equals(numberOfInstances)){
                // 已完成
            } else{
                // 进行中
            }
        }
        return null;
    }

    /**
     * 通过表达式获取其中的变量名
     *
     * @param expression 表达式
     * @return 变量名
     */
    public static String getVariableNameByExpression(String expression) {
        return expression.replace("${", "")
                .replace("}", "");
    }
}
