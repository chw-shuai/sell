package com.imooc.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品包含类目
 * @author 常红伟
 */
@Data
public class ProductVO {

    /**类目名字*/
    @JsonProperty("name")
    private String categoryName;

    /**类目类型*/
    @JsonProperty("type")
    private Integer categoryType;

    /**类目下的商品*/
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;


}
