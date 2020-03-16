package com.example.springbootbase.other.jms.service;

import com.example.springbootbase.other.jms.pojo.User;

/**
 * @author bmr
 * @time 2020-03-04 10:37
 */
public interface RabbitMqService {

    //发送字符串消息
    void sendMsg(String msg);

    //发送用户消息
    void sendUser(User user);
}
