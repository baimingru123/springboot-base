package com.example.springbootbase.chapter12_security.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author bmr
 * @time 2020-03-03 14:41
 */
@Alias("userRole")
@Data
public class UserRole {
    private int id;
    private int roleId;
    private int userId;

}
