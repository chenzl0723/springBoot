package com.chenzl;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by chenzl on 2017/12/11.
 */
@Configuration
@EnableWebSocketMessageBroker // 开启使用STOMP协议来传输基于代理（MessageBroker）的消息
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpointWisely").withSockJS(); //注册一个Stomp的节点（endpoint）,并指定使用SockJS协议。

        registry.addEndpoint("/endpointChat").withSockJS();//1
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");//配置消息代理（MessageBroker）。

        registry.enableSimpleBroker("/queue","/topic"); //2
    }
}
