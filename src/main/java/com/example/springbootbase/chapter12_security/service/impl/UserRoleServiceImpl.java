package com.example.springbootbase.chapter12_security.service.impl;

import com.example.springbootbase.chapter12_security.dao.UserRoleDao;
import com.example.springbootbase.chapter12_security.pojo.Role;
import com.example.springbootbase.chapter12_security.pojo.User;
import com.example.springbootbase.chapter12_security.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bmr
 * @time 2020-03-03 15:22
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public User getUserByName(String userName) {
        return userRoleDao.getUserByName(userName);
    }

    @Override
    public List<Role> findRolesByUserName(String userName) {
        return userRoleDao.findRolesByUserName(userName);
    }
}
