package com.example.springbootbase.other.jms.service;

import com.example.springbootbase.other.jms.pojo.User;

/**
 * @author bmr
 * @time 2020-03-04 9:00
 */
public interface ActiveMqService {
    //发送消息
    void sendMsg(String message);

    //接受消息
    void receiveMsg(String message);

    void sendUser(User user);

    void receiveUser(User user);
}
