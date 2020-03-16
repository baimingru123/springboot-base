package com.example.springbootbase.chapter11_rest.controller;

import com.example.springbootbase.chapter11_rest.service.UserService;
import com.example.springbootbase.chapter11_rest.enums.SexEnum;
import com.example.springbootbase.chapter11_rest.pojo.User;
import com.example.springbootbase.chapter11_rest.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bmr
 * @time 2020-03-02 17:41
 */
@RestController
public class UserController2 {

    @Autowired
    private UserService userService;

    @PostMapping("/user2/entity")
    public ResponseEntity<UserVo> insertUserEntity(@RequestBody UserVo userVo){
        User user=changeToPo(userVo);
        userService.insertUser(user);
        UserVo result=changeToVo(user);
        HttpHeaders httpHeaders=new HttpHeaders();
        String success=(result == null || result.getId()==null )?"false":"true";
        //设置响应头
        httpHeaders.add("success",success);
        //返回创建成功的状态码
        return new ResponseEntity<UserVo>(result,httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping("/user2/annotation")
    @ResponseStatus(HttpStatus.CREATED)
    public UserVo insertUserAnnotation(@RequestBody UserVo userVo){
        User user=changeToPo(userVo);
        userService.insertUser(user);
        return changeToVo(user);
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
}
