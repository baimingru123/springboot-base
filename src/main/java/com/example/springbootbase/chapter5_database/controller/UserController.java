package com.example.springbootbase.chapter5_database.controller;

import com.example.springbootbase.chapter5_database.enumeration.SexEnum;
import com.example.springbootbase.chapter5_database.pojo.User1;
import com.example.springbootbase.chapter5_database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author bmr
 * @time 2020-03-19 16:41
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User1 getUser(@PathVariable("id") long id){
        User1 user1=userService.getUser(id);
        System.out.println(user1);
        return user1;
    }

    @PutMapping("/add")
    public User1 addUser(String user_name,int sex,String note){
        User1 user1=new User1();
        user1.setUserName(user_name);
        user1.setNote(note);
        user1.setSex(SexEnum.getSexEnum(sex));
        System.out.println(user1);
        return userService.insertUser(user1);
    }
}
