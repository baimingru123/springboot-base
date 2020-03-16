package com.example.springbootbase.chapter15.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author bmr
 * @time 2020-03-04 16:59
 */
@Data
@Alias("purchaseRecord")
public class PurchaseRecordPo implements Serializable {

    private static final long serialVersionUID = 8502336133792188511L;
    private int id;
    private int userId;
    private int productId;
    private BigDecimal price;
    private int quantity;
    private BigDecimal sum;
    private Timestamp purchaseDate;
    private String note;
}
