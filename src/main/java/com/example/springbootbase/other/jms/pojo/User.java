package com.example.springbootbase.other.jms.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author bmr
 * @time 2020-03-04 9:11
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 7156881051882684284L;

    private Long id;
    private String userName;
    private String note;
}
