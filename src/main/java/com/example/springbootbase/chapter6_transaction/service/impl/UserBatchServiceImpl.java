package com.example.springbootbase.chapter6_transaction.service.impl;

import com.example.springbootbase.chapter6_transaction.pojo.User;
import com.example.springbootbase.chapter6_transaction.service.UserBatchService;
import com.example.springbootbase.chapter6_transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author bmr
 * @time 2020-02-24 18:07
 */
@Service
public class UserBatchServiceImpl implements UserBatchService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int insertUsers(List<User> userList) {
        int count=0;
        for(User user:userList){
            //调用子方法，将使用@transactional定义的传播行为
            count+=userService.insertUser(user);
        }
        return count;
    }
}
