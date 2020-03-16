package com.example.springbootbase.other.jms.controller;

import com.example.springbootbase.other.jms.pojo.User;
import com.example.springbootbase.other.jms.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bmr
 * @time 2020-03-04 10:54
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitMqController {
    @Autowired
    private RabbitMqService rabbitMqService;

    @GetMapping("/msg")
    public Map msg(String message){
        Map map= new HashMap();
        rabbitMqService.sendMsg(message);
        map.put("success",true);
        map.put("message",message);
        return map;
    }

    //测试user对象的发送
    @GetMapping("/user")
    public Map sendUser(){
        Map map= new HashMap();
        User user=new User();
        user.setId(1L);
        user.setUserName("xmm");
        user.setNote("nn");

        rabbitMqService.sendUser(user);
        map.put("success",true);
        map.put("message",user);
        return map;
    }
}
