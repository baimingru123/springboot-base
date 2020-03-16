package com.example.springbootbase.chapter5_database.pojo;

import com.example.springbootbase.chapter5_database.enumeration.SexEnum;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;

/**
 * @author bmr
 * @time 2020-01-09 11:11
 */
@Data
@Alias("user")
public class User1 {


    private Long id=null;

    private String userName=null;

    private SexEnum sex=null;
    private String note=null;
}
