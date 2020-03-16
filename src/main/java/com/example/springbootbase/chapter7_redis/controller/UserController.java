package com.example.springbootbase.chapter7_redis.controller;

import com.example.springbootbase.chapter7_redis.pojo.User;
import com.example.springbootbase.chapter7_redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bmr
 * @time 2020-02-26 11:34
 */
@RestController
@RequestMapping("/redis_user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUser(Long id){
        return userService.getUser(id);
    }

    @RequestMapping("/insertUser")
    public User insertUser(User user){
        userService.insertUser(user);
        return user;
    }

    @RequestMapping("/findUsers")
    public List<User> findUsers(String userName,String note){
        return userService.findUsers(userName,note);
    }

    @RequestMapping("/updateUserName")
    public Map updateUserName(Long id,String userName){
        User user=userService.updateUserName(id,userName);
        boolean flag=user !=null;
        String message=flag?"更新成功":"更新失败";
        return resultMap(flag,message);
    }

    @RequestMapping("/deleteUser")
    public Map deleteUser(long id){
        int result=userService.deleteUser(id);
        boolean flag=result==1;
        String message=flag?"删除成功":"删除失败";
        return resultMap(flag,message);
    }

    private Map resultMap(boolean success,String message){
        Map result=new HashMap();
        result.put("success",success);
        result.put("message",message);
        return result;
    }
}
