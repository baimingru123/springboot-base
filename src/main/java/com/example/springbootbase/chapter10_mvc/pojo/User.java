package com.example.springbootbase.chapter10_mvc.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author bmr
 * @time 2020-01-10 9:44
 */
@Data
@Alias("user")
public class User implements Serializable {
    private static final long serialVersionUID = -148194467917217782L;

    private Long id;

    private String userName;

    private String note;
}
