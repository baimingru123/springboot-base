package com.example.springbootbase.other.jms.controller;

import com.example.springbootbase.other.jms.pojo.User;
import com.example.springbootbase.other.jms.service.ActiveMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bmr
 * @time 2020-03-04 9:21
 */
@Controller
@RequestMapping("/activemq")
public class ActiveMqController {
    @Autowired
    private ActiveMqService activeMqService;


    //测试普通消息发送
    @GetMapping("/msg")
    @ResponseBody
    public Map msg(String message){
        Map map= new HashMap();
        activeMqService.sendMsg(message);
        map.put("success",true);
        map.put("message",message);
        return map;
    }

    //测试user对象的发送
    @GetMapping("/user")
    @ResponseBody
    public Map sendUser(){
        Map map= new HashMap();
        User user=new User();
        user.setId(1L);
        user.setUserName("xmm");
        user.setNote("nn");

        activeMqService.sendUser(user);
        map.put("success",true);
        map.put("message",user);
        return map;
    }
}
