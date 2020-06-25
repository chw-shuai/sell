package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

/**
 * 推送消息
 * @author 常红伟
 */
public interface PushMessageService {

    /**
     * 订单状态 变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
