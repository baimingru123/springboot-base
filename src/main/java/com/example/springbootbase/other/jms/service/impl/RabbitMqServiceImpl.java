package com.example.springbootbase.other.jms.service.impl;

import com.example.springbootbase.other.jms.pojo.User;
import com.example.springbootbase.other.jms.service.RabbitMqService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author bmr
 * @time 2020-03-04 10:39
 */
@Service
//实现ConfirmCallback接口，这样可以进行回调
public class RabbitMqServiceImpl implements RabbitTemplate.ConfirmCallback, RabbitMqService {

    @Value("${rabbitmq.queue.msg}")
    private String msgRouting;

    @Value("${rabbitmq.queue.user}")
    private String userRouting;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMsg(String msg) {
        System.out.println("发送消息："+msg);
        //设置回调
        rabbitTemplate.setConfirmCallback(this);
        //发送消息，通过msgRouting确定队列
        rabbitTemplate.convertAndSend(msgRouting,msg);
    }

    @Override
    public void sendUser(User user) {
        System.out.println("发送消息："+user);
        //设置回调
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.convertAndSend(userRouting,user);
    }

    //回调方法
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if(ack){
            System.out.println("消息成功消费");
        }else{
            System.out.println("消息消费失败:"+cause);
        }
    }
}
