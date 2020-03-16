package com.example.springbootbase.chapter10_mvc.controller.advice.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author bmr
 * @time 2020-02-29 14:21
 */
@Controller
@RequestMapping("/advice")
public class AdviceController {

    @GetMapping("/test")
    //因为日期格式被控制器通知限定，所以无法在给出
    public String test(Date date, Model model)  {
        //从数据模型中取出数据
        System.out.println(model.getAttribute("project_name"));
        //打印日期参数
        System.out.println(date);
        //抛出异常，这样流转到控制器异常通知
        throw new RuntimeException("异常了，跳转到控制器通知的异常信息里");
    }
}
