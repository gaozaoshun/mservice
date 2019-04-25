package org.gfs.order.server.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.gfs.order.server.dto.OrderDto;
import org.gfs.order.server.enums.HttpCodeEnum;
import org.gfs.order.server.exception.OrderException;
import org.gfs.order.server.form.OrderForm;
import org.gfs.order.server.model.OrderDetail;

import java.util.List;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.order.converter
 * @ClassName OrderForm2OrderDtoConverter
 * @description
 * @date created in 2019-04-15 19:57
 * @modified by
 */
@Slf4j
public class OrderForm2OrderDtoConverter {
    public static OrderDto convert(OrderForm orderForm) {
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName(orderForm.getName());
        orderDto.setBuyerOpenid(orderForm.getOpenid());
        orderDto.setBuyerAddress(orderForm.getAddress());
        orderDto.setBuyerPhone(orderForm.getPhone());

        Gson gson = new Gson();
        List<OrderDetail> orderDetailList;
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            log.error("[JSON转换]错误，string={}", orderForm.getItems());
            throw new OrderException(HttpCodeEnum.PARAM_ERROR);
        }

        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }
}
