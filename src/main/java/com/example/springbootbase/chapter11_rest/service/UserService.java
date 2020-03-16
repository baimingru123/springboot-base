package com.example.springbootbase.chapter11_rest.service;

import com.example.springbootbase.chapter11_rest.pojo.User;

import java.util.List;

/**
 * @author bmr
 * @time 2020-01-10 9:52
 */
public interface UserService {
    //获取用户信息
    User getUser(Long id);

    //新增用户
    User insertUser(User user);

    User updateUserName(Long id, String userName);

    User updateUser(User user);

    List<User> findUsers(String userName, String note);

    List<User> findUsers(String userName, String note,int start,int limit);

    int deleteUser(Long id);
}
