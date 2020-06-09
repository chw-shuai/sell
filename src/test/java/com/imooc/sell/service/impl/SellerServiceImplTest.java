package com.imooc.sell.service.impl;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dataobject.SellerInfo;
import com.imooc.sell.service.SellerService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class SellerServiceImplTest extends SellApplicationTests {

    private static final String OPENID ="abc";

    @Autowired
    SellerService sellerService;

    @Test
    public void findSellerInfoByOpenid() {
        SellerInfo result = sellerService.findSellerInfoByOpenid(OPENID);
        Assert.assertEquals("abc",result.getOpenid());
    }
}