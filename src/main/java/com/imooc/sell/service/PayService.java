package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @author 常红伟
 */
public interface PayService  {

    /**
     * 创建订单
     * @param orderDTO
     */
    PayResponse create(OrderDTO orderDTO);

    /**
     * 异步通知
     * @param notifyData
     * @return
     */
    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);

}
