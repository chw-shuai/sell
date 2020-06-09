package com.imooc.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import com.imooc.sell.utils.EnumUtil;
import com.imooc.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * OrderDTO代表 下单的订单列表，订单列表里面包括订单详情
 * @author 常红伟
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /**订单ID*/
    private String orderId;

    /**买家名字*/
    private String buyerName;

    /**买家电话*/
    private String buyerPhone;

    /** 买家地址*/
    private String buyerAddress;

    /**买家微信openid*/
    private String buyerOpenid;

    /**订单总金额*/
    private BigDecimal orderAmount;

    /**订单状态, 默认为新下单*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**支付状态, 默认为0未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /**创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**修改时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    /**订单详情*/
    List<OrderDetail>orderDetailList = new ArrayList<>();

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
