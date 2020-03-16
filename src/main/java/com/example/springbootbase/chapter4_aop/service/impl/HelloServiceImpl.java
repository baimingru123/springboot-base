package com.example.springbootbase.chapter4_aop.service.impl;

import com.example.springbootbase.chapter4_aop.service.HelloService;

/**
 * @author bmr
 * @time 2020-01-08 14:23
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if(name==null || name.trim().equals("")){
            throw new RuntimeException("parameter is null");
        }

        System.out.println("Hello "+name);
    }
}
