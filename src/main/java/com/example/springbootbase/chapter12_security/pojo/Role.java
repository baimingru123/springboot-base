package com.example.springbootbase.chapter12_security.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author bmr
 * @time 2020-03-03 14:40
 */
@Alias("role")
@Data
public class Role {
    private Integer id;
    private String roleName;
    private String note;
}
