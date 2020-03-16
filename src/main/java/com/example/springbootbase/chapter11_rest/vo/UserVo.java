package com.example.springbootbase.chapter11_rest.vo;

import lombok.Data;

/**
 * @author bmr
 * @time 2020-02-29 16:18
 */
@Data
public class UserVo {
    private Long id;
    private String userName;
    private int sexCode;
    private String sexName;
    private String note;
}
