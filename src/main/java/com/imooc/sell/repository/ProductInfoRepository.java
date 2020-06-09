package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 常红伟
 * 商品详情
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    /**
     * 查询商品状态
     * @param productStatus
     * @return
     */
    List<ProductInfo>findByProductStatus(Integer productStatus);
}
