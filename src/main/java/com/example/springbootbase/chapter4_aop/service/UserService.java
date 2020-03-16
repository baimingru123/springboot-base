package com.example.springbootbase.chapter4_aop.service;

import com.example.springbootbase.chapter3_ioc.pojo.User;

/**
 * @author bmr
 * @time 2020-01-08 16:23
 */
public interface UserService {

    void printUser(User user,boolean test);

    void manyAspects();
}
