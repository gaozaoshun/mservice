package org.gfs.order.server.service;


import org.gfs.order.server.dto.OrderDto;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.order.service
 * @ClassName OrderService
 * @description
 * @date created in 2019-04-15 16:52
 * @modified by
 */
public interface OrderService {
    OrderDto create(OrderDto orderDto);
}
