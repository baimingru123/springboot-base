package com.example.springbootbase.chapter4_aop.service.impl;

import com.example.springbootbase.chapter3_ioc.pojo.User;
import com.example.springbootbase.chapter4_aop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author bmr
 * @time 2020-01-08 16:23
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user,boolean test) {
        if(user == null){
            throw  new RuntimeException("传入参数为空");
        }

        System.out.println("id ="+user.getId());
        System.out.println("username ="+user.getUserName());
        System.out.println("note ="+user.getNote());
        System.out.println("test ="+test);
    }

    @Override
    public void manyAspects() {
        System.out.println("测试多个切面顺序");
    }
}
