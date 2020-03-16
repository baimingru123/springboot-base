package com.example.springbootbase.chapter6_transaction.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author bmr
 * @time 2020-01-10 9:44
 */
@Data
@Alias("user")
public class User {
    private Long id;

    private String userName;

    private String note;
}
