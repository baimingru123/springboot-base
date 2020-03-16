package com.example.springbootbase.chapter4_aop.validator.impl;

import com.example.springbootbase.chapter3_ioc.pojo.User;
import com.example.springbootbase.chapter4_aop.validator.UserValidator;

/**
 * @author bmr
 * @time 2020-01-08 18:08
 */
public class UserValidatorImpl implements UserValidator {

    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口:"+UserValidator.class.getSimpleName());
        return user != null;
    }
}
