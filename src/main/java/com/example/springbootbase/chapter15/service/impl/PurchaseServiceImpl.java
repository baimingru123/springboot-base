package com.example.springbootbase.chapter15.service.impl;

import com.example.springbootbase.chapter15.dao.ProductDao;
import com.example.springbootbase.chapter15.dao.PurchaseRecordDao;
import com.example.springbootbase.chapter15.pojo.ProductPo;
import com.example.springbootbase.chapter15.pojo.PurchaseRecordPo;
import com.example.springbootbase.chapter15.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author bmr
 * @time 2020-03-05 9:28
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private PurchaseRecordDao purchaseRecordDao;


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean purchase(int userId, int productId, int quantity) {
        // 乐观锁会导致请求失败概率的剧增，所以需要通过重入的机制来降低失败率

        //第一种是限制时间戳   第二种是限制重入次数
        //当前时间
        long start=System.currentTimeMillis();

        //循环尝试直至成功
        while (true){
            //循环时间
            long end =System.currentTimeMillis();
            //如果循环时间大于100ms  返回终止循环
            if(end -start >100){
                return false;
            }

            //获取产品(线程旧值)
            ProductPo product=productDao.getProduct(productId);
            if(product == null){
                return  false;
            }

            //比较库存和购买数量
            if(product.getStock() < quantity){
                return false;
            }

            //获取当前版本号
            int version=product.getVersion();

            //扣减库存
            int result=productDao.decreaseProduct(productId,quantity,version);

            //如果更新数据失败，说明数据再多线程中被其他线程修改
            //导致失败，则通过循环冲入尝试购买商品
            if(result == 0){
                continue;
            }

            //初始化购买记录
            PurchaseRecordPo pr=initPurchaseRecord(userId,product,quantity);

            //插入购买记录
            purchaseRecordDao.insertPurchaseRecord(pr);
            return true;
        }

    }

    //初始化购买信息
    private PurchaseRecordPo initPurchaseRecord(int userId,ProductPo productPo,int quantity){
        PurchaseRecordPo pr=new PurchaseRecordPo();
        pr.setNote("购买日志，时间："+System.currentTimeMillis());
        pr.setPrice(productPo.getPrice());
        pr.setProductId(productPo.getId());
        pr.setQuantity(quantity);
        BigDecimal sum= productPo.getPrice().multiply(new BigDecimal(quantity));
        pr.setSum(sum);
        pr.setUserId(userId);
        return pr;
    }
}
