package com.imooc.sell.utils;

import java.util.Random;

/**
 *
 *
 * @author 常红伟
 */

public class KeyUtil {

    /**
     * 随机唯一的主键
     * 格式：时间加上随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();

        Integer number = random.nextInt(900000)+ 100000;

        return  System.currentTimeMillis()+String.valueOf(number);
    }
}
