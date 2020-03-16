package com.example.springbootbase.other.webSocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author bmr
 * @time 2020-03-04 15:12
 */
@Configuration
public class WebSocketConfig {

    //创建服务器端点
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
