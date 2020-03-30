package com.example.springbootbase.chapter11_rest.controller;

import com.example.springbootbase.chapter11_rest.enums.SexEnum;
import com.example.springbootbase.chapter11_rest.pojo.User;
import com.example.springbootbase.chapter11_rest.service.UserService;
import com.example.springbootbase.chapter11_rest.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bmr
 * @time 2020-02-29 16:20
 */
@Controller
@Api(value ="用户接口api" ,tags = "用户接口api相关controller")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/restful")
//    @ApiIgnore
    public String index(){
        return "restful";
    }

    @PostMapping("/user")
    @ResponseBody
    @ApiOperation(value = "获取用户列表",notes = "获取用户列表")
    public User insertUser(@RequestBody UserVo userVo){
        System.out.println("userVo:"+userVo);
        User user=this.changeToPo(userVo);
        System.out.println("user:"+user);
        return userService.insertUser(user);
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public UserVo getUser(@PathVariable("id") long id){
        System.out.println("id:"+id);
        User user=userService.getUser(id);
        System.out.println(user);
        return changeToVo(user);
    }

    @GetMapping("/users/{userName}/{note}/{start}/{limit}")
    @ResponseBody
    public List<User> findUsers(@PathVariable("userName") String userName,@PathVariable("note") String note,
                                @PathVariable("start") int start,@PathVariable("limit") int limit){
        System.out.println("userName:"+userName+",note:"+note+",start:"+start+",limit:"+limit);
        List<User> users=userService.findUsers(userName,note,start,limit);
        System.out.println("users:"+users);
        return users;
    }

    @PutMapping("/user/{id}")
    @ResponseBody
    public User updateUser(@PathVariable("id") long id,@RequestBody UserVo userVo){
        User user=changeToPo(userVo);
        user.setId(id);
        System.out.println(user);
        return userService.updateUser(user);
    }

    @GetMapping("/user/name")
    public String changeUserName(){
        return "change_user_name";
    }

    @PatchMapping("/user/name")
    @ResponseBody
    public User changeUserName2(Long id,String userName){
        User user=userService.updateUserName(id,userName);
        return user;
    }



    //将vo转换为po
    private User changeToPo(UserVo userVo){
        User user=new User();
        user.setId(userVo.getId());
        user.setUserName(userVo.getUserName());
        user.setSex(SexEnum.getSexEnum(userVo.getSexCode()));
        user.setNote(userVo.getNote());
        return user;
    }

    //将po转换为vo
    private UserVo changeToVo(User user){
        UserVo userVo=new UserVo();
        userVo.setId(user.getId());
        userVo.setNote(user.getNote());
        userVo.setSexCode(user.getSex().getCode());
        userVo.setSexName(user.getSex().getName());
        userVo.setUserName(user.getUserName());
        return userVo;
    }

    //将po列表转换为vo列表
    private List<UserVo> changeToVos(List<User> userList){
        List<UserVo> voList=new ArrayList<>();
        for(User user:userList){
            UserVo userVo=changeToVo(user);
            voList.add(userVo);
        }
        return voList;
    }

    private Map<String,String> resultMap(String success,String message){
        Map<String,String> result=new HashMap<>();
        result.put(success,message);
        return result;
    }
}
