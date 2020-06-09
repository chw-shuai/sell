package com.imooc.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 常红伟
 */
@Data
public class ProductForm {


    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品单价
     */
    private BigDecimal productPrice;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 商品小图连接
     */
    private String productIcon;

    /**
     * 类目编号
     */
    private Integer categoryType;

}
