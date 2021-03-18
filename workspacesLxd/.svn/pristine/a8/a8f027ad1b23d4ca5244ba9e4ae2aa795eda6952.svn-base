package com.ruoyi.mq.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.session.StandardSessionFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * @author 736421789@qq.com
 * @date 2020/1/23 12:19
 */

@Component
@Slf4j
public class WebSocketConfig extends ServerEndpointConfig.Configurator{

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        StandardSessionFacade ssf = (StandardSessionFacade) request.getHttpSession();
        if (ssf != null) {
            HttpSession httpSession = (HttpSession) request.getHttpSession();
            //关键操作
            sec.getUserProperties().put("sessionId", httpSession.getId());
            log.info("获取到的SessionID：" + httpSession.getId());
        }
        super.modifyHandshake(sec, request, response);

    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}













//import com.ruoyi.mq.interceptor.EchoWebSocketHandler;
//import com.ruoyi.mq.interceptor.ReverseWebSocketEndpoint;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//import org.springframework.web.socket.server.standard.ServerEndpointExporter;
//@Configuration
//public class WebSocketConfig  implements WebSocketConfigurer {
//
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(echoWebSocketHandler(), "/echoMessage");
//        registry.addHandler(echoWebSocketHandler(), "/echoMessage_SockJS").withSockJS();
//    }
//
//    /**
//     * 通过继承 {@link org.springframework.web.socket.handler.AbstractWebSocketHandler} 的示例
//     */
//    @Bean
//    public WebSocketHandler echoWebSocketHandler(){
//        return new EchoWebSocketHandler();
//    }
//
//
//    @Bean
//    public ReverseWebSocketEndpoint reverseWebSocketEndpoint() {
//        return new ReverseWebSocketEndpoint();
//    }
//    /**
//     * 注入ServerEndpointExporter，
//     * 这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
//     *
//     * @return
//     */
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }
//}