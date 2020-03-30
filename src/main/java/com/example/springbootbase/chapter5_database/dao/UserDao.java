package com.example.springbootbase.chapter5_database.dao;

import com.example.springbootbase.chapter5_database.pojo.User1;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author bmr
 * @time 2020-03-19 16:41
 */
@Mapper
public interface UserDao {
    User1 getUser(long id);

    int insertUser(User1 user1);
}
