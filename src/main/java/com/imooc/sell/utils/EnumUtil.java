package com.imooc.sell.utils;

import com.imooc.sell.enums.CodeEnum;

/**
 * @author 常红伟
 */
    public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumsClass){
        for (T each:enumsClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
