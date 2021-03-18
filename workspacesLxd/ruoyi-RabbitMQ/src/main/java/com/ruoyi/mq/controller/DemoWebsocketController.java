package com.ruoyi.mq.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.mq.config.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/demo/websocket")
public class DemoWebsocketController extends BaseController{
    private String prefix = "views";

    @Autowired
    private WebSocketServer webSocketServer;

    @GetMapping()
    public String socket()
    {
        return prefix + "/index";
    }

//    @RequiresPermissions("demo:websocket:edit")
    //推送数据接口
    @ResponseBody
    @RequestMapping("/push/{cid}")
    public Map pushToWeb(@PathVariable String cid, String message) {
        if(message==null){
            message = "我是消息44";
        }
        Map result = new HashMap();
        try {
            webSocketServer.sendMessageTo(message,"shiqingbin");
            result.put("code", 200);
            result.put("msg", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
