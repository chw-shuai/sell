package com.imooc.sell.constant;

/**
 *
 * redis常量
 * @author 常红伟
 */
public interface RedisConstant {

    /**
     * 前缀
     */
    String TOKEN_PREFIX = "token_%s";

    /**
     * 过期时间
     * 2小时
     */
    Integer EXPIRE = 7200;
}
