package com.imooc.sell.controller;

import com.imooc.sell.config.ProjectUrlConfig;
import com.imooc.sell.constant.CookieConstant;
import com.imooc.sell.constant.RedisConstant;
import com.imooc.sell.dataobject.SellerInfo;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.service.SellerService;
import com.imooc.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 *
 * 卖家用户
 * @author 常红伟
 */

@Controller
@RequestMapping("/seller")
@Slf4j
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid")String openid,
                              HttpServletResponse response,
                              Map<String,Object> map){
        //1.openid  和  数据库里的数据做匹配
        log.info("openid=");

        openid = "oTgZpwcFtDHhK4AnEKJkt6Ju_nAY";
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        log.info("sellerInfo={}",sellerInfo);
        if (sellerInfo == null){
           map.put("msg",ResultEnum.LOGIN_FAIL.getMesssage());
           map.put("url","/sell/seller/order/list");
           return new ModelAndView("common/error");
        }

        //2.设置token到 redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        /**
         *  第一个参数   String.format(RedisConstant.TOKEN_PREFIX,token)    redis的key
         *  第二个参数   openid   redis的value
         *  第三个参数   expire  过期时间
         *  第四个参数   TimeUnit.SECONDS   时间的单位/秒
         */
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openid,expire,TimeUnit.SECONDS);

        //3.设置token 到cookie
        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
        return new ModelAndView("redirect:"+projectUrlConfig.getSell()+"/sell/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Map<String,Object>map){
        //1.从cookie里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null){
            //2.清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
            CookieUtil.set(response,CookieConstant.TOKEN,null,0);
            //3.清除token
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMesssage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);

    }
}
