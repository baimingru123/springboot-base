package com.example.springbootbase.chapter10_mvc.dao;

import com.example.springbootbase.chapter10_mvc.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author bmr
 * @time 2020-01-10 9:44
 */
@Repository
public interface UserDao {

    User getUser(Long id);

    int insertUser(User user);

    int updateUser(User user);

    List<User> findUsers(@Param("userName") String userName, @Param("note") String note);

    int deleteUser(Long id);
}
