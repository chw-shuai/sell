package com.imooc.sell.enums;

import lombok.Getter;

/**
 *
 * 商品状态
 * @author 常红伟
 */

@Getter
public enum ProductStatusEnum implements CodeEnum {

    UP(0,"在架"),

    OFF_SHELF(1,"下架")



    ;
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }
}
