package com.imooc.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 表单验证
 * @author 常红伟
 */

@Data
public class OrderForm {


    /**
     * 姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 电话
     */
    @NotEmpty(message = "电话必填")
    private String phone;

    /**
     * 地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * openid
     */
    @NotEmpty(message = "openId必填")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
