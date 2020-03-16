package com.example.springbootbase.chapter12_security.dao;

import com.example.springbootbase.chapter12_security.pojo.User;
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

    List<User> findUsersLimit(@Param("userName") String userName, @Param("note") String note, @Param("start") int start, @Param("limit") int limit);

    int deleteUser(Long id);
}
