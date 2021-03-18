package com.ruoyi.mq.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.ruoyi.mq.bean.LoginLog;
import com.ruoyi.mq.bean.SysConstant;
import com.ruoyi.mq.config.CustomMessageSender;
import com.ruoyi.mq.service.MsgService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.IdentityLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author japhet_jiu
 * @version 1.0
 */

@RestController
@RequestMapping("rabbitmq")
public class MQController {

    @Autowired
    private MsgService msgService;

    @Autowired
    private CustomMessageSender customMessageSender;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRuntime taskRuntime;
    Logger log = LoggerFactory.getLogger(MQController.class);
    @GetMapping("sendMsg")
    public String sendMsg() {
        log.info("发送延时消息时间:" + DateUtil.formatDateTime(DateUtil.date()));

        LoginLog loginLog = new LoginLog();
        loginLog.setLoginIp("1.204.219.129");
        loginLog.setLoginOperation("测试mq");
        loginLog.setLoginTime(new Date());
        loginLog.setLoginUserId(1L);

        msgService.sendDelayMsgToMQ(SysConstant.SYS_ORDER_DELAY_EXCHANGE,SysConstant.SYS_ORDER_DELAY_KEY, JSONUtil.toJsonStr(loginLog),10*3000);//30秒钟后执行
        return JSONUtil.toJsonStr("发送延时消息成功"+new Date());
    }
    @GetMapping("sendMsgs")
    public String sendMsgs() {
        log.info("发送延时消息时间:" + DateUtil.formatDateTime(DateUtil.date()));

        LoginLog loginLog = new LoginLog();
        loginLog.setLoginIp("1.204.219.129");
        loginLog.setLoginOperation("测试mq");
        loginLog.setLoginTime(new Date());
        loginLog.setLoginUserId(1L);

        msgService.sendDelayMsgToMQ(SysConstant.SYS_ORDER_DELAY_EXCHANGE,SysConstant.SYS_ORDER_DELAY_KEY, JSONUtil.toJsonStr(loginLog),10*3000);//30秒钟后执行
        return JSONUtil.toJsonStr("发送延时消息成功"+new Date());
    }
}
