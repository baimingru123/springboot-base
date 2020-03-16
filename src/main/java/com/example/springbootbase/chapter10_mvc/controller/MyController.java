package com.example.springbootbase.chapter10_mvc.controller;

import com.example.springbootbase.chapter10_mvc.pojo.User;
import com.example.springbootbase.chapter10_mvc.pojo.ValidatorPojo;
import com.example.springbootbase.chapter10_mvc.validator.UserValidator;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bmr
 * @time 2020-02-27 16:39
 */
@Controller
public class MyController {


    @GetMapping("/valid/page")
    public String validPage(){
        System.out.println("准备跳转pojo.jsp页面");
        return "/validator/pojo";
    }

    @RequestMapping("/valid/validate")
    @ResponseBody
    public Map validate(@Valid @RequestBody ValidatorPojo vp, Errors errors){
        Map errMap=new HashMap();
        List<ObjectError> oes=errors.getAllErrors();
        for (ObjectError oe:oes){
            String key=null;
            String msg=null;

            if(oe instanceof FieldError){
                FieldError fe=(FieldError) oe;
                key=fe.getField();
            }else{
                key=oe.getObjectName();
            }

            msg=oe.getDefaultMessage();
            errMap.put(key,msg);
        }
        System.out.println(errMap);
        return errMap;
    }
}
