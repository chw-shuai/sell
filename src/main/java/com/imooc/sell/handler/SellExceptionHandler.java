package com.imooc.sell.handler;


import com.imooc.sell.config.ProjectUrlConfig;
import com.imooc.sell.exception.ResponseBankException;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.exception.SellerAuthorizeException;
import com.imooc.sell.utils.ResultVOUtil;
import com.imooc.sell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 常红伟
 */

@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    /**
     * 拦截登陆异常
     * http://sell.springboot.cn/sell/wechat/qrAuthorize?returnUrl=http://chw-sell.natapp1.cc/sell/seller/login
     * @return
     */
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"
                .concat("http://sell.springboot.cn")
                .concat("/sell/wechat/qrAuthorize?")
                .concat("returnUrl=")
                .concat(projectUrlConfig.getSell())
                .concat("/sell/seller/login"));
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleResponseBankException(){

    }
}
