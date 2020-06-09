package com.imooc.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Json格式化工具
 * @author 常红伟
 */
public class JsonUtil {

    /**
     * 将对象转换为Json格式
     * @param object
     * @return
     */
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);

    }
}
