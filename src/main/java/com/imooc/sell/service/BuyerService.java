package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

/**
 * @author 常红伟
 */
public interface BuyerService {

    /**
     * 查询一个订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消一个订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO cancelOrderOne(String openid, String orderId);

}
