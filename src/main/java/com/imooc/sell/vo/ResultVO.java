package com.imooc.sell.vo;

import lombok.Data;

/**
 * @author 常红伟
 */
@Data
public class ResultVO <T>{

    /**错误码*/
    private Integer code;

    /**提示信息*/
    private String msg;

    /**返回数据*/
    private T data;


}
