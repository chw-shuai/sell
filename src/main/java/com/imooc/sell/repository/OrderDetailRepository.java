package com.imooc.sell.repository;


import com.imooc.sell.dataobject.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 订单详情接口
 *
 * 查询订单详情    首先肯定会从订单表里取到 订单的id  根据 id  去 订单详情表查询id对应的详情表
 * 订单表 和  订单详情 表  1  对 多
 * @author 常红伟
 *
 *
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
    /**
     *
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
