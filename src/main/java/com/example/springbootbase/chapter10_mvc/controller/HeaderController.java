package com.example.springbootbase.chapter10_mvc.controller;

import com.example.springbootbase.chapter10_mvc.pojo.User;
import com.example.springbootbase.chapter10_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author bmr
 * @time 2020-02-29 14:40
 */
@Controller
@RequestMapping("/header")
public class HeaderController {
    @Autowired
    private UserService userService;


    @GetMapping("/page")
    public String headerPage(){
        return "header";
    }

    @PostMapping("/user")
    @ResponseBody
    public User headerUser(@RequestHeader("id") long id){
        User user=userService.getUser(id);
        return user;
    }
}
