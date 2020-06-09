package com.imooc.sell.service.impl;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.service.PayService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;


public class PayServiceImplTest extends SellApplicationTests {

    private final String ORDER_ID = "1590649530311897431";

    @Autowired
    PayService payService;

    @Autowired
    OrderService orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        payService.create(orderDTO);
    }

    @Test
    public void refund(){
        OrderDTO orderDTO = orderService.findOne("1591268122238900843");
        payService.refund(orderDTO);
    }
}