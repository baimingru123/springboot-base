package com.example.springbootbase.chapter12_security.service.impl;

import com.example.springbootbase.chapter12_security.pojo.Role;
import com.example.springbootbase.chapter12_security.pojo.User;
import com.example.springbootbase.chapter12_security.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bmr
 * @time 2020-03-03 14:36
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //获取数据库用户信息
        User dbUser=userRoleService.getUserByName(userName);
        //获取数据库角色信息
        List<Role> roleList=userRoleService.findRolesByUserName(userName);

        return changeToUser(dbUser,roleList);
    }

    private UserDetails changeToUser(User user,List<Role> roleList){
        //权限列表
        List<GrantedAuthority> authorityList=new ArrayList<>();

        //赋予查询到的角色
        for(Role role:roleList){
            GrantedAuthority authority=new SimpleGrantedAuthority(role.getRoleName());
            authorityList.add(authority);
        }

        //创建UserDetails对象，设置用户名、密码和权限
        UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPwd(),authorityList);
        return userDetails;
    }
}
