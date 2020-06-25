package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 常红伟
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMesssage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String messages){
        super(messages);
        this.code = code;

    }

}
