package com.example.springbootbase.chapter5_database.typehandler;

import com.example.springbootbase.chapter5_database.enumeration.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author bmr
 * @time 2020-01-09 14:48
 */
//声明jdbcType为整形
@MappedJdbcTypes(JdbcType.INTEGER)
//声明javaType为sexEnum
@MappedTypes(value = SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {

    //设置非空性别参数
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sexEnum.getCode());
    }

    //通过列名读取性别
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sex= resultSet.getInt(s);
        System.out.println("数据库中的sex："+sex);
        if(sex !=1 && sex !=2){
            return null;
        }
        SexEnum sexEnum=SexEnum.getSexEnum(sex);
        System.out.println(sexEnum);
        return sexEnum;
    }

    //通过下标读取性别
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sex= resultSet.getInt(i);
        System.out.println("数据库中的sex："+sex);
        if(sex !=1 && sex !=2){
            return null;
        }
        SexEnum sexEnum=SexEnum.getSexEnum(sex);
        System.out.println("查询出来的对象："+sexEnum);
        return sexEnum;
    }

    //通过存储过程读取性别
    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sex= callableStatement.getInt(i);
        if(sex !=1 && sex !=2){
            return null;
        }
        return SexEnum.getSexEnum(sex);
    }
}
