package com.ruoyi.collection.utils;

import cn.hutool.json.JSONUtil;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.mq.bean.SysConstant;
import com.ruoyi.mq.service.MsgService;
import com.ruoyi.system.service.ISysUserService;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ActUtils {
    @Autowired
    private MsgService msgService;

//    @Autowired
//    private IActWorkflowFormDataService actWorkflowFormDataService;


    public  static String submitTask(RuntimeService runtimeService, ProcessRuntime processRuntime, LoginUser loginUser, String uuid, Map<String, Object> variables
            , TaskService taskService, TaskRuntime taskRuntime, String key, String withName, String id){
        //查询部门为当前登陆人，角色为分公司负责人,角色临时写死
        if(!"".equals(uuid) && uuid!=null){
            org.activiti.engine.runtime.ProcessInstance processInstances = runtimeService.createProcessInstanceQuery().processInstanceId(uuid).singleResult();

            runtimeService.deleteProcessInstance(processInstances.getId(), "结束");

            ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
                    .start()
                    .withProcessDefinitionKey(key)
                    .withName(withName)
                    .withBusinessKey(id)
                    .withVariables(variables)
                    //.withVariable("companyFinaAudit",sysUser.getUserName())
                    .build());
            String InstanceId = (processInstance.getId());
            // 根据流程实例Id查询任务
            Task task =  taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
            //完成任务
            taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId())
                    .build());

//            new ActUtils().saveActData(task,processInstance,loginUser);
            return InstanceId;
        }else{
            ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
                    .start()
                    .withProcessDefinitionKey(key)
                    .withName(withName)
                    .withBusinessKey(id)
                    .withVariables(variables)
                    //.withVariable("companyFinaAudit",sysUser.getUserName())
                    .build());
            String InstanceId = (processInstance.getId());
            // 根据流程实例Id查询任务
            Task task =  taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
            //完成任务
            taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId())
                    .build());
//            new ActUtils().saveActData(task,processInstance,loginUser);
            return InstanceId;
        }


    }

    public  void saveActData(Task task, ProcessInstance processInstances, LoginUser loginUser){
        //
//        ActWorkflowFormData data = new ActWorkflowFormData();
//        data.setBusinessKey(processInstances.getBusinessKey());
//        data.setFormKey(task.getFormKey());
//        data.setControlId("apply");
//        data.setCreateName("提交");
//        data.setControlValue("同意");
//        data.setTaskNodeName("经办人申请");
//        data.setCreateName(loginUser.getUser().getNickName());
//        data.setCreateBy(loginUser.getUsername());
//        data.setCreateTime(new Date());
//        data.setExecutionId(task.getExecutionId());
//        List<ActWorkflowFormData> list = new ArrayList<>();
//        list.add(data);
//        int num = actWorkflowFormDataService.insertActWorkflowFormDatas(list);
    }
    public  static String submitTask(ProcessRuntime processRuntime, LoginUser loginUser, String uuid, Map<String, Object> variables
    , TaskService taskService,TaskRuntime taskRuntime,String key,String withName){
        //查询部门为当前登陆人，角色为分公司负责人,角色临时写死

            ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
                    .start()
                    .withProcessDefinitionKey(key)
                    .withName(withName)
                    .withBusinessKey(uuid)
                    .withVariables(variables)
                    //.withVariable("companyFinaAudit",sysUser.getUserName())
                    .build());
            String InstanceId = (processInstance.getId());
            // 根据流程实例Id查询任务
            Task task =  taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
            //完成任务
            taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId())
                    .build());
//            new ActUtils().saveActData(task,processInstance,loginUser);
            return InstanceId;

    }
    /**
     * 获取各个流程组人员
     * @param dept_id
     * @return
     */
    public static String getVarirs(Long dept_id,String roleid,ISysUserService iSysUserService){
        List<String> ulist = new ArrayList();
        Map params = new HashMap();
        params.put("roleId",roleid);
        params.put("deptId",dept_id);
        List<SysUser> users = iSysUserService.selectUserByRoleDept(params);
        SysUser sysUser = new SysUser();
        if(users!=null && users.size()>0){
            for (SysUser user:users)  {
                ulist.add(user.getUserName());
            }
            //sysUser = users.get(0) ;
        }
        String str = org.apache.commons.lang.StringUtils.join(ulist.toArray(),",");
        return str;
    }


    /**
     * 获取各个流程组人员
     * @return
     */
    public static List<SysUser> getVarirs(Map map,ISysUserService iSysUserService){
        List<SysUser> users = iSysUserService.selectUserByRoleDept(map);
        return users;
    }

    public void submitNgTask(ProcessRuntime processRuntime, LoginUser loginUser, String uuid, Map<String, Object> variables
            , TaskService taskService,TaskRuntime taskRuntime,String key,String withName){
        //查询部门为当前登陆人，角色为分公司负责人,角色临时写死
//        ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
//                .start()
//                .withProcessDefinitionKey(key)
//                .withName(withName)
//                .withBusinessKey(uuid)
//                .withVariables(variables)
//                //.withVariable("companyFinaAudit",sysUser.getUserName())
//                .build());
//        String InstanceId = (processInstance.getId());
        // 根据流程实例Id查询任务
       // Task task =  taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        //完成任务
        Map map = new HashMap();
        map.put("key",key);
        map.put("widthName",withName);
        map.put("loginUser",loginUser);
        map.put("id",uuid);
        map.put("variables",variables);
        msgService.sendDelayMsgToMQ(SysConstant.SYS_NG_EXCHANGE,SysConstant.SYS_NG_KEY, JSONUtil.toJsonStr(map),0);//30秒钟后执行
//        taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId())
//                .build());
//        return InstanceId;
    }
}
