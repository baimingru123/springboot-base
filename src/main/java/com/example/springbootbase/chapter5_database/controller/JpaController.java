package com.example.springbootbase.chapter5_database.controller;

import com.example.springbootbase.chapter5_database.dao.JpaUserRepository;
import com.example.springbootbase.chapter5_database.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author bmr
 * @time 2020-01-09 11:37
 */
@Controller
@RequestMapping("/jpa")
public class JpaController {
    @Autowired
    private JpaUserRepository jpaUserRepository;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id){
        User user=jpaUserRepository.findById(id).get();
        return user;
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUserById(Long id){
        User user=jpaUserRepository.getUserById(id);
        return user;
    }

    @RequestMapping("/findByUserNameLike")
    @ResponseBody
    public List<User> findByUserNameLike(String userName){
        List<User> userList=jpaUserRepository.findByUserNameLike(userName);
        return userList;
    }

    @RequestMapping("/findByUserNameLikeOrNoteLike")
    @ResponseBody
    public List<User> findByUserNameLikeOrNoteLike(String userName,String note){
        userName="%"+userName+"%";
        note="%"+note+"%";
        List<User> userList=jpaUserRepository.findByUserNameLikeOrNoteLike(userName,note);
        return userList;
    }
}
