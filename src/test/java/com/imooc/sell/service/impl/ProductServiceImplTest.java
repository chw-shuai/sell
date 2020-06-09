package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    ProductServiceImpl productInfoService;

    @Test
    public void findOne() {
        ProductInfo result = productInfoService.findOne("123456");
        Assert.assertEquals("123456", result.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoServiceUpAll = productInfoService.findUpAll();
        Assert.assertNotEquals(0,productInfoServiceUpAll.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());

    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("223456");
        productInfo.setProductName("香辣鸡翅");
        productInfo.setProductPrice(BigDecimal.valueOf(20));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃的香辣鸡翅");
        productInfo.setProductIcon("http://******.jpg");
        productInfo.setProductStatus(ProductStatusEnum.OFF_SHELF.getCode());
        productInfo.setCategoryType(1);
        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void onSale(){
        ProductInfo productInfo = productInfoService.onSale("1");
        Assert.assertEquals(ProductStatusEnum.UP,productInfo.getProductStatusEnum());
    }

    @Test
    public void offSale(){
        ProductInfo productInfo = productInfoService.offSale("1");
        Assert.assertEquals(ProductStatusEnum.OFF_SHELF,productInfo.getProductStatusEnum());
    }
}