package com.example.springbootbase.chapter6_transaction.dao;

import com.example.springbootbase.chapter6_transaction.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author bmr
 * @time 2020-01-10 9:44
 */
public interface UserDao {

    User getUser(Long id);

    int insertUser(User user);
}
