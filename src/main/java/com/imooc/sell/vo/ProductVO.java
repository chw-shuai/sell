package com.imooc.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品包含类目
 * @author 常红伟
 */
@Data
public class ProductVO implements Serializable {


    private static final long serialVersionUID = 6118793959200854533L;


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
