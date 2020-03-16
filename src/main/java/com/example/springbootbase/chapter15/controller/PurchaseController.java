package com.example.springbootbase.chapter15.controller;

import com.example.springbootbase.chapter15.service.PurchaseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author bmr
 * @time 2020-03-05 9:38
 */
@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    //定义jsp视图
    @GetMapping("/test")
    public ModelAndView testPage(){
        ModelAndView mv=new ModelAndView("test");
        return mv;
    }

    @PostMapping("/purchase")
    public Result purchase(int userId,int productId,int quantity){
        boolean success=purchaseService.purchase(userId,productId,quantity);
        String message=success?"抢购成功":"抢购失败";
        Result result=new Result(success,message);
        return result;
    }


    @Data
    class Result{
        private boolean success;
        private String message;

        public Result(){
        }

        public Result(boolean success,String message){
            this.success=success;
            this.message=message;
        }
    }
}



