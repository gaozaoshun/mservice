package org.gfs.order.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.gfs.order.server.converter.OrderForm2OrderDtoConverter;
import org.gfs.order.server.dto.OrderDto;
import org.gfs.order.server.enums.HttpCodeEnum;
import org.gfs.order.server.enums.ResultCodeEnum;
import org.gfs.order.server.exception.OrderException;
import org.gfs.order.server.form.OrderForm;
import org.gfs.order.server.service.OrderService;
import org.gfs.order.server.tool.HttpResultTool;
import org.gfs.order.server.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.order.controller
 * @ClassName OrderController
 * @description
 * @date created in 2019-04-15 14:43
 * @modified by
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVo<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("[创建订单] 参数校验不通过 orderForm={}", orderForm);
            throw new OrderException(HttpCodeEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        // orderFrom -> orderDto
        OrderDto orderDto = OrderForm2OrderDtoConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDto.getOrderDetailList())) {
            log.error("[创建订单] 购物车信息为空");
            throw new OrderException(ResultCodeEnum.CART_EMPTY);
        }
        OrderDto result = orderService.create(orderDto);
        Map<String, String> orderMap = new HashMap<>(1);
        orderMap.put("orderId", result.getOrderId());
        return HttpResultTool.success(orderMap);
    }
}
