package com.example.springbootbase.chapter15.service;

/**
 * @author bmr
 * @time 2020-03-05 9:26
 */
public interface PurchaseService {

    /**
     * 处理购买业务
     * @param userId  用户编号
     * @param productId 产品编号
     * @param quantity  购买数量
     * @return  成功  or  失败
     */
    public boolean purchase(int userId,int productId,int quantity);
}
