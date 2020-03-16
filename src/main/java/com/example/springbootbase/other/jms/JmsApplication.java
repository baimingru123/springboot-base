package com.example.springbootbase.other.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author bmr
 * @time 2020-03-04 9:28
 */
@SpringBootApplication(exclude ={SecurityAutoConfiguration.class})
public class JmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(JmsApplication.class,args);
    }
}
