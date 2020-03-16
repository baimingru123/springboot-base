package com.example.springbootbase.chapter6_transaction.service.impl;

import com.example.springbootbase.chapter6_transaction.dao.UserDao;
import com.example.springbootbase.chapter6_transaction.pojo.User;
import com.example.springbootbase.chapter6_transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bmr
 * @time 2020-01-10 9:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public User
    getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
