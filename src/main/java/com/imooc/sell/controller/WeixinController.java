/*

package com.imooc.sell.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


*/
/**
 * @author 常红伟
 *//*


@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code")String code){
        log.info("进入auth方法...");
        log.info("code={}",code);

        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxa2076af2b8441fec&secret=da3d0ded3e2ceb417ffb690afe53db77&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}",response);

    }
}

*/
