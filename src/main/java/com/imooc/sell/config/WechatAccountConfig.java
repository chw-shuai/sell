package com.imooc.sell.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 常红伟
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    /**
     * 公众号平台id
     */
    private String mpAppId;

    /**
     * 公众平台密钥
     */
    private String mpAppSecret;

    /**
     * 开放平台id
     */
    private String openAppId;

    /**
     * 开放平台密钥
     */
    private String openAppSecret;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 商户密钥
     */
    private String mchKey;

    /**
     * 商户证书路径
     */
    private String keyPath;

    /**
     * 微信异步通知地址
     */
    private String  notifyUrl;

    private String mpAuthrizeAppId;

    /**
     * 微信模板id
     */
    private Map<String,String> templateId;

    /**
     * 微信模板appid
     */
    private String templateAppId;

    /**
     * 微信模板Appsecret
     */
    private String templateAppsecret;

    /**
     * 微信模板Openid
     */
    private String templateOpenid;

}
