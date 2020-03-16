package com.example.springbootbase.chapter12_security.dao;

import com.example.springbootbase.chapter12_security.pojo.Role;
import com.example.springbootbase.chapter12_security.pojo.User;

import java.util.List;

/**
 * @author bmr
 * @time 2020-03-03 15:15
 */
public interface UserRoleDao {

   User getUserByName(String userName);

    List<Role> findRolesByUserName(String userName);
}
