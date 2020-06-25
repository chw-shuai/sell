package com.imooc.sell.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 常红伟
 */
@Data
public class ResultVO <T> implements Serializable {


    private static final long serialVersionUID = 6789875563893296223L;


    /**错误码*/
    private Integer code;

    /**提示信息*/
    private String msg;

    /**返回数据*/
    private T data;


}
