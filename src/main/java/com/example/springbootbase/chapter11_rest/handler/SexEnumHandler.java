package com.example.springbootbase.chapter11_rest.handler;

import com.example.springbootbase.chapter11_rest.enums.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author bmr
 * @time 2020-03-02 9:42
 */
public class SexEnumHandler extends BaseTypeHandler<SexEnum> {

    private Class<SexEnum> type;
    private SexEnum[] enums;

    /**
     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现
     */
    public SexEnumHandler(Class<SexEnum> type){
        if(type ==null){
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type=type;
        this.enums=type.getEnumConstants();
        if(this.enums==null){
            throw new IllegalArgumentException(type.getSimpleName()+" does not represent an enum type.");
        }
    }


    /**
     * 将枚举类型转换为数据库中的类型
     * @param preparedStatement
     * @param i
     * @param sexEnum
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sexEnum.getCode());
    }

    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        //根据数据库存储类型决定获取类型，本例子中的数据库存放的是int类型
        int code=resultSet.getInt(columnName);
        if(resultSet.wasNull()){
            return null;
        }else{
            //根据数据库中存放的值，获取SexEnum
            return SexEnum.getSexEnum(code);
        }
    }

    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        //根据数据库存储类型决定获取类型，本例子中的数据库存放的是int类型
        int code=resultSet.getInt(columnIndex);
        if(resultSet.wasNull()){
            return null;
        }else{
            //根据数据库中存放的值，获取SexEnum
            return SexEnum.getSexEnum(code);
        }
    }

    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        //根据数据库存储类型决定获取类型，本例子中的数据库存放的是int类型
        int code=callableStatement.getInt(columnIndex);
        if(callableStatement.wasNull()){
            return null;
        }else{
            //根据数据库中存放的值，获取SexEnum
            return SexEnum.getSexEnum(code);
        }
    }
}
