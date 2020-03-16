package com.example.springbootbase.chapter10_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bmr
 * @time 2020-02-28 16:40
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

    @GetMapping("/start")
    public String start(){
        System.out.println("执行处理器逻辑");
        return "/welcome";
    }
}
