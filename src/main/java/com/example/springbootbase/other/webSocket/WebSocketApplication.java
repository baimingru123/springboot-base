package com.example.springbootbase.other.webSocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author bmr
 * @time 2020-03-04 15:03
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WebSocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class,args);
    }
}
