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
public class OrderMasterRepositoryTest {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    private final String OPENID ="4851a23das";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456332");
        orderMaster.setBuyerName("王庆");
        orderMaster.setBuyerPhone("17610057172");
        orderMaster.setBuyerAddress("山西管理职业学院");
        orderMaster.setBuyerOpenid("abc123");
        orderMaster.setOrderAmount(BigDecimal.valueOf(2.3));
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = new PageRequest(1,3);
        Page<OrderMaster> result = orderMasterRepository.findByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotEquals(0,result.getTotalElements());

    }
}