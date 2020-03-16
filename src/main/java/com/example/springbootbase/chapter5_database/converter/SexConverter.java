package com.example.springbootbase.chapter5_database.converter;

import com.example.springbootbase.chapter5_database.enumeration.SexEnum;

import javax.persistence.AttributeConverter;

/**
 * jpa 枚举数据和数据库列的转换实现类
 * @author bmr
 * @time 2020-01-09 11:31
 */
public class SexConverter implements AttributeConverter<SexEnum,Integer> {

    //将枚举转换为数据库列
    @Override
    public Integer convertToDatabaseColumn(SexEnum sexEnum) {
        return sexEnum.getId();
    }

    //将数据库列转换为枚举
    @Override
    public SexEnum convertToEntityAttribute(Integer id) {
        return SexEnum.getEnumById(id);
    }
}
