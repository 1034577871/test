package com.ruoyi.mq.config;

import com.ruoyi.mq.bean.SysConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ配置类
 * @author japhet_jiu
 * @version 1.0
 */

@Configuration
public class FphxMQConfig {

    /**
     * 死信接收交换机,用于接收死信队列的消息
     * @return
     */
    @Bean
    public DirectExchange sysOrderReceiveExchange() {
        return new DirectExchange(SysConstant.SYS_FPHX_EXCHANGE);
    }

    /**
     * 死信接收队列
     * @return
     */
    @Bean
    public Queue sysOrderReceiveQueue() {
        return new Queue(SysConstant.SYS_FPHX_QUEUE);
    }

    /**
     * 死信接收交换机绑定接收死信队列消费队列
     * @return
     */
    @Bean
    public Binding sysOrdeReceiveBinding() {
        return BindingBuilder.bind(sysOrderReceiveQueue()).to(sysOrderReceiveExchange()).with(SysConstant.SYS_FPHX_KEY);
    }



}
