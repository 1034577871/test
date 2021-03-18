package com.ruoyi.listen;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.collection.mapper.CtBuInvoiceReqDetailMapper;
import com.ruoyi.mq.bean.SysConstant;
import com.ruoyi.mq.config.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

//import com.ruoyi.mq.config.WebSocketServerEndpoint;


/**
 * 接收消息监听类
 * @author japhet_jiu
 * @version 1.0
 */
@Component
@EnableRabbit
@Slf4j
public class ReceiveMsgListener {
    private final Logger log= LoggerFactory.getLogger(ReceiveMsgListener.class);
    @Autowired
    private WebSocketServer webSocketServer;

    @Autowired
    private CtBuInvoiceReqDetailMapper ctBuInvoiceReqDetailMapper;
    @Autowired
    private RestTemplate restTemplate;
    //  AES加密解密
    private String sKey = "785641234654";
    private String ivParamter = "0392039203";
    //queue指要监听列队的名字
    @RabbitListener(queues = SysConstant.SYS_ORDER_RECEIVE_QUEUE)
    public void reveiverDirectQueue(String message){
        decrypt(message);
    }
    public JSONObject decrypt(String message) {
        try {

            //获取代办信息

            JSONObject object = JSON.parseObject(message);
            List<String> ulist = (List)object.get("users");
            String name = object.getString("name");
            String status = object.getString("status")==null?"":object.getString("status");
            // websocket发送消息
            if(!CollectionUtils.isEmpty(ulist)){
                for(String user :ulist){
                    Map map = ctBuInvoiceReqDetailMapper.selectTaskCount(user);
                    if(status!=null && "4".equals(status)){
                        name = name;
                    }else{
                        name = map.get("count")==null?"0":map.get("count").toString()+"条代办任务，请及时处理";
                    }
                    webSocketServer.sendMessageTo(name,user);
                    log.info(map.toString());
                    log.info(user+"监听消息：" + message);
                }
            }
            return object;
        } catch (Exception ex) {
            return null;
        }
    }
}
