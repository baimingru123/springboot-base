package com.example.springbootbase.chapter4_aop.validator;

import com.example.springbootbase.chapter3_ioc.pojo.User;

/**
 * @author bmr
 * @time 2020-01-08 18:06
 */
public interface UserValidator {
    //检测用户对象是否为空
    boolean validate(User user);
}
