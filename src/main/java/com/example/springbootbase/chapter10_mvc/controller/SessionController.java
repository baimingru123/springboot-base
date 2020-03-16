package com.example.springbootbase.chapter10_mvc.controller;

import com.example.springbootbase.chapter10_mvc.pojo.User;
import com.example.springbootbase.chapter10_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author bmr
 * @time 2020-02-29 11:13
 */
//@SessionAttributes指定数据模型名称或者属性类型，保存到Session中
@SessionAttributes(names = {"user"},types = Long.class)
@Controller
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private UserService userService;

    @GetMapping("/page")
    public String page(){
        return "session";
    }

    @GetMapping("/test")
    //@SessionAttribute从HttpSession中取出数据，填充控制器方法参数
    public String test(@SessionAttribute("id") Long id, Model model){
        //根据类型保存到Session中
        model.addAttribute("id_new",id);
        User user=userService.getUser(id);
        //根据名称保存到Session中
        model.addAttribute("user",user);
        return "session/test";
    }
}
