package com.example.springbootbase.chapter12_security.service;

import com.example.springbootbase.chapter12_security.pojo.Role;
import com.example.springbootbase.chapter12_security.pojo.User;

import java.util.List;

/**
 * @author bmr
 * @time 2020-01-10 9:52
 */
public interface UserRoleService {
    //获取用户信息
    User getUserByName(String userName);

    //获取用户权限列表
    List<Role> findRolesByUserName(String userName);

}
