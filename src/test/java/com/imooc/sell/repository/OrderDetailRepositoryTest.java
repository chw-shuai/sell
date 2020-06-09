package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("123456");
        orderDetail.setDetailId("112233");
        orderDetail.setProductId("1");
        orderDetail.setProductName("香酥酥的鸡");
        orderDetail.setProductPrice(BigDecimal.valueOf(30));
        orderDetail.setProductQuantity(2);
        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception{
        List<OrderDetail> result = orderDetailRepository.findByOrderId("1585037210374581671");
        Assert.assertNotEquals(0, result.size());

    }

}