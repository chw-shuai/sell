package com.imooc.sell.converter;

import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 *转换类
 * @author 常红伟
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();

        BeanUtils.copyProperties(orderMaster,orderDTO);

        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMastersList){
        List<OrderDTO> orderDTOS = orderMastersList.stream().map(OrderMaster2OrderDTOConverter::convert).collect(Collectors.toList());

        return orderDTOS;
    }
}
