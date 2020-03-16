package com.example.springbootbase.chapter15.dao;

import com.example.springbootbase.chapter15.pojo.ProductPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author bmr
 * @time 2020-03-05 9:09
 */
@Mapper
public interface ProductDao {

    //获取产品
    ProductPo getProduct(int id);

    //减库存
    int decreaseProduct(@Param("id") int id,@Param("quantity") int quantity,@Param("version") int version);
}
