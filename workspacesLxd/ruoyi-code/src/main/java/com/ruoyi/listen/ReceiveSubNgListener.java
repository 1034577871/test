//package com.ruoyi.listen;
//
//
//import cn.hutool.json.JSONUtil;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.ruoyi.mq.bean.SysConstant;
//import com.ruoyi.mq.service.MsgService;
//import com.ruoyi.projectApproval.ApprovalNg.mapper.CtBuApprovalNgMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.activiti.api.process.model.ProcessInstance;
//import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
//import org.activiti.api.process.runtime.ProcessRuntime;
//import org.activiti.api.task.model.builders.TaskPayloadBuilder;
//import org.activiti.api.task.runtime.TaskRuntime;
//import org.activiti.engine.RuntimeService;
//import org.activiti.engine.TaskService;
//import org.activiti.engine.task.IdentityLink;
//import org.activiti.engine.task.Task;
//import org.activiti.engine.task.TaskQuery;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
////import com.ruoyi.mq.config.WebSocketServerEndpoint;
//
//
///**
// * 接收消息监听类
// * @author japhet_jiu
// * @version 1.0
// */
//@Component
//@EnableRabbit
//@Slf4j
//public class ReceiveSubNgListener {
//    private final Logger log= LoggerFactory.getLogger(ReceiveSubNgListener.class);
//    @Autowired
//    private TaskRuntime taskRuntime;
//    @Autowired
//    private TaskService taskService;
//
//    @Autowired
//    private ProcessRuntime processRuntime;
//    @Autowired
//    private CtBuApprovalNgMapper ctBuApprovalNgMapper;
//
//    @Autowired
//    private RuntimeService runtimeService;
//    @Autowired
//    private MsgService msgService;
//    //queue指要监听列队的名字
//    @RabbitListener(queues = SysConstant.SYS_NG_QUEUE)
//    @Transactional(rollbackFor = Exception.class)
//    public void reveiverDirectQueue(String message){
//        decrypt(message);
//    }
//    public JSONObject decrypt(String message) {
//        try {
//
//
//            ProcessInstance processInstance1 = runtimeService.startProcessInstanceByKey("baoxiao", variables);
//            ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
//                    .start()
//                    .withProcessDefinitionKey(key)
//                    .withName(withName)
//                    .withBusinessKey(uuid)
//                    .withVariables(variables)
//                    //.withVariable("companyFinaAudit",sysUser.getUserName())
//                    .build());
//            String InstanceId = (processInstance.getId());
//            // 根据流程实例Id查询任务
//            Task task =  taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
//            //完成任务
//            taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId())
//                    .build());
//
//            return obj;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
//}
