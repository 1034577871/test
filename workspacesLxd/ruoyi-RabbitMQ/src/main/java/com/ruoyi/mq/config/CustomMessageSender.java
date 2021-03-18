package com.ruoyi.mq.config;

import com.alibaba.fastjson.JSON;
import com.ruoyi.mq.utils.IdWorker;
import com.ruoyi.mq.utils.MqConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/**
 * deliveryTag:该消息的index
 * multiple：是否批量.true:将一次性ack所有小于deliveryTag的消息。
 *  channel.basicAck(deliveryTag, false);
 * basicRecover：是路由不成功的消息可以使用recovery重新发送到队列中。重新投递并没有所谓的像basicReject中的basicReject的deliveryTag参数，所以重新投递好像是将消费者还没有处理的所有的消息都重新放入到队列中，而不是将某一条消息放入到队列中，与basicReject不同的是，重新投递可以指定投递的消息是否允许当前消费者消费。
 * basicReject：（void basicReject(long deliveryTag, boolean requeue);）是接收端告诉服务器这个消息我拒绝接收,不处理,可以设置是否放回到队列中还是丢掉，而且只能一次拒绝一个消息,官网中有明确说明不能批量拒绝消息，为解决批量拒绝消息才有了basicNack。requeue=true,表示将消息重新放入到队列中，false：表示直接从队列中删除，此时和basicAck(long deliveryTag, false)的效果一样
 * basicNack：可以一次拒绝N条消息，客户端可以设置basicNack方法的multiple参数为true，服务器会拒绝指定了delivery_tag的所有未确认的消息(tag是一个64位的long值，最大值是9223372036854775807)。
 */

/**
 * 自定义消息发送类
 * 增强RabbitTemplate
 * @author Yan
 */
@Component
public class CustomMessageSender implements RabbitTemplate.ConfirmCallback{

    static final Logger log = LoggerFactory.getLogger(CustomMessageSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IdWorker idWorker;
    /**
     * 构造方法
     * @param rabbitTemplate
     */
    public CustomMessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }

    /**
     * 生产者通知回调方法
     * @param correlationData 唯一标识
     * @param ack 成功/失败
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        //消费放发送消息成功后，返回成功通知
        if (ack){
            //删除redis中的相关数据
            redisTemplate.delete(correlationData.getId());
            redisTemplate.delete(MqConstant.MESSAGE_CONTENT +correlationData.getId());
            log.info("消息已成功到达rabbitmq服务器。。。");
        }else{
            //重新在Redis中获取消息的内容
            log.error("消息发送异常，准备再次发送。。。");
            Map<String,String> map =(Map<String,String>)redisTemplate.opsForHash().entries(MqConstant.MESSAGE_CONTENT + correlationData.getId());
            String exchange = map.get("exchange");
            String routingKey = map.get("routingKey");
            String sendMessage = map.get("sendMessage");
            //重新发送
            rabbitTemplate.convertAndSend(exchange,routingKey, JSON.toJSONString(sendMessage));
        }
    }

    /**
     * 自定义发送方法
     * @param exchange      交换器
     * @param routingKey    路由键
     * @param message       消息内容
     */
    public boolean sendMessage(String exchange,String queue ,String routingKey,String message){

        try {
            //设置消息唯一标识并存入缓存
            String messageId = idWorker.nextId()+"";
            CorrelationData correlationData = new CorrelationData(messageId);
            redisTemplate.opsForValue().set(correlationData.getId(),message);
            //以消息唯一Id微主键，在Redis中保存消息的重发次数
            redisTemplate.opsForValue().set(MqConstant.MESSAGE_RECEIVED_COUNT + correlationData.getId(), MqConstant.INIT_COUNT);
            //设置消息属性，消息Id
            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setMessageId(messageId);
//        messageProperties.setContentType("text/plain");
//        messageProperties.setContentEncoding("utf-8");
            Message messageObj = new Message(message.getBytes(), messageProperties);

            //将消息元信息存入Redis缓存
            Map<String, String> map = new HashMap<>();
            map.put("exchange", exchange);
            map.put("routingKey", routingKey);
            map.put("sendMessage", message);
            redisTemplate.opsForHash().putAll(MqConstant.MESSAGE_CONTENT +correlationData.getId(), map);

            //携带唯一标识发送消息，消息幂等
            rabbitTemplate.convertAndSend(exchange, routingKey, messageObj, correlationData);
            return true;
        } catch (AmqpException e) {
            e.printStackTrace();
            return false;
        }
    }
}
