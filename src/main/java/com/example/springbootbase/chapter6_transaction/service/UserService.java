package com.example.springbootbase.chapter6_transaction.service;

import com.example.springbootbase.chapter6_transaction.pojo.User;

/**
 * @author bmr
 * @time 2020-01-10 9:52
 */
public interface UserService {
    //获取用户信息
    User getUser(Long id);

    //新增用户
    int insertUser(User user);
}
