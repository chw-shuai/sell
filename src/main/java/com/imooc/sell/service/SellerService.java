package com.imooc.sell.service;

import com.imooc.sell.dataobject.SellerInfo;

/**
 * 卖家端
 * @author 常红伟
 */

public interface SellerService {

    /**
     * 通过opendi查询卖家信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
