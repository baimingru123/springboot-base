package com.example.springbootbase.chapter12_security.pojo;

import com.example.springbootbase.chapter11_rest.enums.SexEnum;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author bmr
 * @time 2020-02-29 16:15
 */
@Alias("securityUser")
@Data
public class User {
    private int id;
    private String userName;
    private String pwd;
    private Integer available;
    private String note;
}
