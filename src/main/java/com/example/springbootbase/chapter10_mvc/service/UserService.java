package com.example.springbootbase.chapter10_mvc.service;

import com.example.springbootbase.chapter10_mvc.pojo.User;

import java.util.List;

/**
 * @author bmr
 * @time 2020-01-10 9:52
 */
public interface UserService {
    //获取用户信息
    User getUser(Long id);

    //新增用户
    int insertUser(User user);

    User updateUserName(Long id, String userName);

    List<User> findUsers(String userName, String note);

    int deleteUser(Long id);
}
