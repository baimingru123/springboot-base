package com.example.springbootbase.chapter6_transaction.service;

import com.example.springbootbase.chapter6_transaction.pojo.User;

import java.util.List;

/**
 * @author bmr
 * @time 2020-02-24 18:06
 */
public interface UserBatchService {
    public int insertUsers(List<User> userList);
}
