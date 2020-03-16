package com.example.springbootbase.chapter5_database.dao;

import com.example.springbootbase.chapter5_database.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author bmr
 * @time 2020-01-09 11:36
 */
public interface JpaUserRepository extends JpaRepository<User,Long> {

    @Query("from user where user_name like concat('%',?1,'%') and note like concat(?2,'%') ")
    List<User> findUsers(String userName, String note);

    /**
     * 按用户名称模糊查询
     * @param userName  用户名
     * @return  用户列表
     */
    List<User> findByUserNameLike(String userName);

    /**
     * 根据主键查询
     * @param id   主键
     * @return  用户
     */
    User getUserById(Long id);

    /**
     * 按照用户名称或者备注进行模糊查询
     * @param userName  用户名
     * @param note  备注
     * @return  用户列表
     */
    List<User> findByUserNameLikeOrNoteLike(String userName,String note);
}
