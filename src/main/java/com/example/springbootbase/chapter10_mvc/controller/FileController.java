package com.example.springbootbase.chapter10_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bmr
 * @time 2020-02-28 15:14
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @GetMapping("/upload/page")
    public String uploadPage(){
        return "/file/upload";
    }

    /**
     * 使用HttpServletRequest作为参数
     * @param request
     * @return
     */
    @PostMapping("/upload/request")
    @ResponseBody
    public Map uploadRequest(HttpServletRequest request){
        Map result=new HashMap();
        boolean flag=false;
        MultipartHttpServletRequest mreq=null;
        if(request instanceof MultipartHttpServletRequest){
            mreq= (MultipartHttpServletRequest) request;
        }else{
            result.put("success",flag);
            result.put("message","上传失败");
            return result;
        }

        //获取MultipartFile文件信息
        MultipartFile mf=mreq.getFile("file");
        //获取源文件名称
        String fileName=mf.getOriginalFilename();
        File file=new File(fileName);
        try {
            mf.transferTo(file);
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",flag);
            result.put("message","上传失败");
            return result;
        }
        flag=true;
        result.put("success",flag);
        result.put("message","上传成功");
        return result;

    }

    //使用spring mvc的multipartFile类作为参数
    @PostMapping("/upload/multipart")
    @ResponseBody
    public Map uploadMultipartFile(MultipartFile mf){
        Map result=new HashMap();
        boolean flag=false;
        String fileName=mf.getOriginalFilename();
        File file=new File(fileName);
        try {
            mf.transferTo(file);
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",flag);
            result.put("message","上传失败");
            return result;
        }
        flag=true;
        result.put("success",flag);
        result.put("message","上传成功");
        return result;
    }

    //使用servlet的part类作为参数
    @PostMapping("/upload/part")
    @ResponseBody
    public Map uploadPart(Part file){
        Map result=new HashMap();
        boolean flag=false;
        String fileName=file.getSubmittedFileName();

        try{
            file.write(fileName);
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",flag);
            result.put("message","上传失败");
            return result;
        }
        flag=true;
        result.put("success",flag);
        result.put("message","上传成功");
        return result;
    }
}
