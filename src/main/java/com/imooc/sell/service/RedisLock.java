package com.imooc.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.xml.core.Commit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author 常红伟
 */
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 加锁
     * @param key   orderId
     * @param value   现在时间加过期时间
     * @return
     */
    public boolean lock(String key,String value){
        //采用Redis中SETNX方法，如果没有值将进行设值，成功设值说明抢占到锁就返回true，假如有值则说明有线程在使用锁则设值失败返回false，抢锁失败
        if (stringRedisTemplate.opsForValue().setIfAbsent(key, value)){
            //抢锁成功则返回true
            return true;
        }
        //获取当前线程key的value值，即该order的过期时间
        String currentValue = stringRedisTemplate.opsForValue().get(key);
        //若 当前线程过期时间 不为空，并且 过期时间 小于 当前时间 则为过期 ，大于当前时间表示 未过期
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()){
            //假如当前线程时间没有过期   则使用Redis的GETSET方法。先获取 上一个线程的过期时间 再set 当前线程的得过期时间
            String oldValue = stringRedisTemplate.opsForValue().getAndSet(key,value);
                //若 上一个线程的过期时间 等于 当前线程的过期时间，返回true则能解开死锁情况
                if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)){
                    return true;
                }
        }
        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key,String value){
        try {
            String currentValue = stringRedisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)){
                stringRedisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            log.error("【redis分布式锁】解锁异常，{}",e);
        }
    }
}
