package com.example.springbootbase.chapter11_rest.pojo;

import com.example.springbootbase.chapter11_rest.enums.SexEnum;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author bmr
 * @time 2020-02-29 16:15
 */
@Alias("user")
@Data
public class User {
    private Long id;
    private String userName;
    private SexEnum sex;
    private String note;
}
