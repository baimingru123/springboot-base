package com.example.springbootbase.other.jms.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bmr
 * @time 2020-03-04 10:33
 */
@Configuration
public class RabbitMqConfig {
    //消息队列名称
    @Value("${rabbitmq.queue.msg}")
    private String msgQueueName;

    //用户队列名称
    @Value("${rabbitmq.queue.user}")
    private String userQueueName;

    @Bean
    public Queue createQueueMsg(){
        //创建字符串消息队列，boolean值代表是否持久化消息
        return new Queue(msgQueueName,true);
    }

    @Bean
    public Queue createQueueUser(){
        //创建用户消息队列，boolean值代表是否持久化消息
        return new Queue(userQueueName,true);
    }
}
