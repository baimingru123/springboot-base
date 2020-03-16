package com.example.springbootbase.other.jms.service.impl;

import com.example.springbootbase.other.jms.pojo.User;
import com.example.springbootbase.other.jms.service.ActiveMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author bmr
 * @time 2020-03-04 9:01
 */
@Service
public class ActiveMqServiceImpl implements ActiveMqService {

    //注入由spring boot自动生产的jmsTemplate
    @Autowired
    private JmsTemplate jmsTemplate;

    //自定义地址
    private static final String myDestination="my-destination";


    @Override
    public void sendMsg(String message) {
        System.out.println("发送消息【"+message+"】");
        jmsTemplate.convertAndSend(message);
        //自定义发送地址
//        jmsTemplate.convertAndSend("your-address",message);
    }

    @Override
    //使用注解，监听地址发送过来的消息
    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void receiveMsg(String message) {
        System.out.println("接受到信息：【"+message+"】");
    }

    @Override
    public void sendUser(User user) {
        System.out.println("发送消息【"+user+"】");
        jmsTemplate.convertAndSend(myDestination,user);
    }

    @Override
    @JmsListener(destination = myDestination)
    public void receiveUser(User user) {
        System.out.println("接受到信息：【"+user+"】");
    }
}
