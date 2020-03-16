package com.example.springbootbase.chapter5_database.pojo;

import com.example.springbootbase.chapter5_database.converter.SexConverter;
import com.example.springbootbase.chapter5_database.enumeration.SexEnum;
import lombok.Data;

import javax.persistence.*;

/**
 * @author bmr
 * @time 2020-01-09 11:11
 */
@Data
@Entity(name = "user")
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id=null;

    @Column(name = "user_name")
    private String userName=null;

    @Convert(converter = SexConverter.class)
    private SexEnum sex=null;
    private String note=null;
}
