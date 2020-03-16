package com.example.springbootbase.other.async_thread_pools.controller;

import com.example.springbootbase.other.async_thread_pools.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bmr
 * @time 2020-03-03 17:21
 */
@Controller
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/page")
    public String asyncPage(){
        System.out.println("报表线程名称："+"【"+Thread.currentThread().getName()+"】");
        asyncService.generateReport();
        return "async";
    }
}
