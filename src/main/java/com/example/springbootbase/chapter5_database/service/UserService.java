package com.example.springbootbase.chapter5_database.service;

import com.example.springbootbase.chapter5_database.dao.UserDao;
import com.example.springbootbase.chapter5_database.pojo.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bmr
 * @time 2020-03-19 16:41
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User1 getUser(long id){
        return userDao.getUser(id);
    }

    public User1 insertUser(User1 user1){
        userDao.insertUser(user1);
        return user1;
    }
}
