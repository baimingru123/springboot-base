package com.example.springbootbase.chapter15.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author bmr
 * @time 2020-03-04 16:56
 */
@Alias("product")
@Data
public class ProductPo implements Serializable {

    private static final long serialVersionUID = 5372829876962493683L;
    private int id;
    private String productName;
    private int stock;
    private BigDecimal price;
    private int version;
    private String note;


}
