package com.example.springbootbase.chapter4_aop.controller;

import com.example.springbootbase.chapter3_ioc.pojo.User;
import com.example.springbootbase.chapter4_aop.service.UserService;
import com.example.springbootbase.chapter4_aop.service.impl.UserServiceImpl;
import com.example.springbootbase.chapter4_aop.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author bmr
 * @time 2020-01-08 16:46
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/print")
    @ResponseBody
    public User printUser(Long id,String username,String note){
        User user=new User();
        user.setId(id);
        user.setUserName(username);
        user.setNote(note);

        UserValidator userValidator=(UserValidator)userService;
        if(userValidator.validate(user)){
            userService.printUser(user,true);
        }
        return user;
    }

    @RequestMapping("/manyAspects")
    @ResponseBody
    public String manyAspects () {
        userService.manyAspects( );
        return "manyAspects";
    }
}
