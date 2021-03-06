package com.imooc.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 常红伟
 */
@Data
public class ProductInfoVO implements Serializable {


    private static final long serialVersionUID = 1121635981720412497L;


    @JsonProperty("id")
    private String productId;

    /**
     * 商品名称
     */
    @JsonProperty("name")
    private String productName;

    /**
     * 商品单价
     */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /**
     * 商品描述
     */
    @JsonProperty("description")
    private String productDescription;

    /**
     * 商品小图连接
     */
    @JsonProperty("icon")
    private String productIcon;
}
