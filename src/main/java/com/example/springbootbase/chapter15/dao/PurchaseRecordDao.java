package com.example.springbootbase.chapter15.dao;

import com.example.springbootbase.chapter15.pojo.ProductPo;
import com.example.springbootbase.chapter15.pojo.PurchaseRecordPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author bmr
 * @time 2020-03-05 9:09
 */
@Mapper
public interface PurchaseRecordDao {

    //插入购买记录
    int insertPurchaseRecord(PurchaseRecordPo purchaseRecordPo);

}
