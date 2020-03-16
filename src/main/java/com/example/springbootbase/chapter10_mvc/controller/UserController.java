package com.example.springbootbase.chapter10_mvc.controller;

import com.example.springbootbase.chapter10_mvc.pojo.User;
import com.example.springbootbase.chapter10_mvc.service.UserService;
import com.example.springbootbase.chapter10_mvc.validator.UserValidator;
import com.example.springbootbase.chapter10_mvc.view.PdfExportService;
import com.example.springbootbase.chapter10_mvc.view.PdfView;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.Valid;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bmr
 * @time 2020-02-27 10:35
 */
@Controller
@RequestMapping("/mvc_user")
public class UserController {

    @Autowired
    private UserService userService;
//
//    @RequestMapping("/table")
//    public ModelAndView table(){
//        //访问模型层得到数据
//        List<User> userList=userService.findUsers(null,null);
//        ModelAndView mv=new ModelAndView();
//        mv.setViewName("user/table");
//        mv.addObject("userList",userList);
//        return mv;
//    }
//
//    @RequestMapping("/list")
//    @ResponseBody
//    public List<User> list(@RequestParam(value = "userName",required = false) String userName,@RequestParam(value = "note",required = false) String note){
//        List<User> userList=userService.findUsers(userName,note);
//        return userList;
//    }

    /**
     * 调用控制器前先执行这个方法
     */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        //绑定自定义的验证器
        binder.setValidator(new UserValidator());
        //定义日期参数格式，参数不再需要注解@DateTimeFormat,boolean参数表示是否允许为空
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));
    }

    @GetMapping("/custom_validator")
    @ResponseBody
    public Map customValidator(@Valid User user, Errors errors,Date date){
        Map map=new HashMap();
        map.put("user",user);
        map.put("date",date);

        //判断是否存在错误
        if(errors.hasErrors()){
            //获取全部错误
            List<ObjectError> oes=errors.getAllErrors();
            for(ObjectError oe:oes){
                //判断是否字段错误
                if(oe instanceof FieldError){
                    //字段错误
                    FieldError fe= (FieldError) oe;
                    map.put(fe.getField(),fe.getDefaultMessage());
                }else{
                    //对象错误
                    map.put(oe.getObjectName(),oe.getDefaultMessage());
                }
            }
        }
        return map;
    }

    @GetMapping("/convert")
    @ResponseBody
    public User getUserByConvert(User user){
        return user;
    }

    @GetMapping("/export/pdf")
    public ModelAndView exportPdf(String userName,String note){
        //查询用户信息列表
        List<User> userList=userService.findUsers(userName,note);
        //定义PDF视图
        View view=new PdfView(exportService());
        ModelAndView mv=new ModelAndView();
        //设置视图
        mv.setView(view);
        //加入数据模型
        mv.addObject("userList",userList);
        return mv;
    }

    //导出PDF自定义
    @SuppressWarnings("unchecked")
    private PdfExportService exportService(){
        //使用Lambda表达式自定义导出
        return (model,document,writer,request,response)->{
            //A4纸张
            document.setPageSize(PageSize.A4);
            //标题
            document.addTitle("用户信息");
            //换行
            document.add(new Chunk("\n"));
            //表格，3列
            PdfPTable table=new PdfPTable(3);
            //单元格
            PdfPCell cell=null;
            //字体，定义为蓝色加粗
            Font f8=new Font();
            f8.setColor(Color.BLUE);
            f8.setStyle(Font.BOLD);

            //标题
            cell=new PdfPCell(new Paragraph("id",f8));
            //居中对齐
            cell.setHorizontalAlignment(1);
            //将单元格加入表格
            table.addCell(cell);

            cell=new PdfPCell(new Paragraph("user_name",f8));
            cell.setHorizontalAlignment(1);
            table.addCell(cell);

            cell=new PdfPCell(new Paragraph("note",f8));
            cell.setHorizontalAlignment(1);
            table.addCell(cell);

            //获取数据模型中的用户列表
            List<User> userList= (List<User>) model.get("userList");
            for(User user:userList){
                document.add(new Chunk("\n"));
                cell=new PdfPCell(new Paragraph(user.getId()+""));
                table.addCell(cell);

                cell=new PdfPCell(new Paragraph(user.getUserName()));
                table.addCell(cell);

                cell=new PdfPCell(new Paragraph(user.getNote()));
                table.addCell(cell);
            }

            //在文档中加入表格
            document.add(table);
        };
    }
}
