package com.example.springbootbase.chapter11_rest.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author bmr
 * @time 2020-02-29 16:18
 */
@Data
@ApiModel("用户vo")
public class UserVo {
    private Long id;

    @ApiModelProperty(value = "用户名",required = true,example = "张三")
    private String userName;

    @ApiModelProperty(value = "性别",required = true,notes = "只能填写1男,2女",example = "1")
    private int sexCode;

    private String sexName;

    private String note;
}
