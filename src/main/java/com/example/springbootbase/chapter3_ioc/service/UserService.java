package com.example.springbootbase.chapter3_ioc.service;

import com.example.springbootbase.chapter3_ioc.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author bmr
 * @time 2019-12-30 15:14
 */
@Service
public class UserService {
    public void printUser () {
        User user=new User();
        user.setId(3L);
        user.setUserName("user_service_user_name_3");
        user.setNote("user_service_user_note_3");
        System.out.println ("编号:" +user.getId () ) ;
        System.out.println ("用户名称:" +user.getUserName () ) ;
        System.out.println ("备注:" +user.getNote () ) ;
    }
}
