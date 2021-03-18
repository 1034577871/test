package com.ruoyi.mq.interceptor.impl;

import com.ruoyi.mq.interceptor.EchoService;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * Echo Demo
 * @author zifangsky
 * @date 2018/10/9
 * @since 1.0.0
 */
@Service("echoServiceImpl")
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String message) {
        return MessageFormat.format("Did you say \"{0}\"?", message);
    }
}
