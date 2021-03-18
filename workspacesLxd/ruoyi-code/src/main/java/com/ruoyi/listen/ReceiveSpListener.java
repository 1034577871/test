package com.ruoyi.listen;


import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.collection.mapper.CtBuInvoiceReqDetailMapper;
import com.ruoyi.mq.bean.SysConstant;
import com.ruoyi.mq.service.MsgService;
import com.ruoyi.projectApproval.ApprovalNg.mapper.CtBuApprovalNgMapper;
import lombok.extern.slf4j.Slf4j;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

//import com.ruoyi.mq.config.WebSocketServerEndpoint;


/**
 * 接收消息监听类
 * @author japhet_jiu
 * @version 1.0
 */
@Component
@EnableRabbit
@Slf4j
public class ReceiveSpListener {
    private final Logger log= LoggerFactory.getLogger(ReceiveSpListener.class);
    @Autowired
    private TaskRuntime taskRuntime;
    @Autowired
    private TaskService taskService;

    @Autowired
    private ProcessRuntime processRuntime;
    @Autowired
    private CtBuApprovalNgMapper ctBuApprovalNgMapper;

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private MsgService msgService;
    @Autowired
    private  CtBuInvoiceReqDetailMapper ctBuInvoiceReqDetailMapper;
    //queue指要监听列队的名字
    @RabbitListener(queues = SysConstant.SYS_SP_QUEUE)
    @Transactional(rollbackFor = Exception.class)
    public void reveiverDirectQueue(String message){
        decrypt(message);
    }
    public JSONObject decrypt(String message) {
        try {

            JSONObject obj = JSON.parseObject(message);
            String instanceId = obj.getString("instanceId");
            String widthName = obj.getString("name");
            List<String> users = (List)obj.get("users");
            if(users!=null && !"".equals(users)){

                //发送消息
                Map map = new HashMap();
                map.put("users",users);
                map.put("name",widthName);
                System.out.println("******************************************************888"+users.size());
                System.out.println(users.get(0));
                msgService.sendDelayMsgToMQ(SysConstant.SYS_ORDER_DELAY_EXCHANGE,SysConstant.SYS_ORDER_DELAY_KEY, JSONUtil.toJsonStr(map),0);//30秒钟后执行


            }

            return obj;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
