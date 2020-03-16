package com.example.springbootbase.chapter6_transaction.controller;

import com.example.springbootbase.chapter6_transaction.pojo.User;
import com.example.springbootbase.chapter6_transaction.service.UserBatchService;
import com.example.springbootbase.chapter6_transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author bmr
 * @time 2020-01-10 11:12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserBatchService userBatchService;

    @RequestMapping("/getUser")
    public User getUser(Long id){
        return userService.getUser(id);
    }

    @RequestMapping("/insertUser")
    public Map<String,Object> insertUser(String userName,String note){
        User user=new User();
        user.setUserName(userName);
        user.setNote(note);

        int update=userService.insertUser(user);
        Map<String,Object> result=new HashMap<>();
        result.put("success",update==1);
        result.put("user",user);
        return result;
    }

    @RequestMapping("/insertUsers")
    public Map<String,Object> insertUsers(String userName1,String note1,String userName2,String note2){
        User user1=new User();
        user1.setUserName(userName1);
        user1.setNote(note1);

        User user2=new User();
        user2.setUserName(userName2);
        user2.setNote(note2);

        List<User> userList=Stream.of(user1,user2).collect(Collectors.toList());
        int update=userBatchService.insertUsers(userList);
        Map<String,Object> result=new HashMap<>();
        result.put("success",update>0);
        result.put("user",userList);
        return result;
    }
}
