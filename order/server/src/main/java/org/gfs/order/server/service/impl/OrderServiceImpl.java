package org.gfs.order.server.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.gfs.order.server.dao.OrderDetailDao;
import org.gfs.order.server.dao.OrderMasterDao;
import org.gfs.order.server.dto.OrderDto;
import org.gfs.order.server.enums.OrderStatusEnum;
import org.gfs.order.server.enums.PayStatusEnum;
import org.gfs.order.server.model.OrderDetail;
import org.gfs.order.server.model.OrderMaster;
import org.gfs.order.server.service.OrderService;
import org.gfs.order.server.tool.KeyTool;
import org.gfs.product.client.ProductClient;
import org.gfs.product.common.DecreaseStockInput;
import org.gfs.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.order.service.impl
 * @ClassName OrderServiceImpl
 * @description
 * @date created in 2019-04-15 16:52
 * @modified by
 */
@Service
@Slf4j
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrderMasterDao orderMasterDao;
    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDto create(OrderDto orderDto) {
        String orderId = KeyTool.getUniqueKey();
        // 1、查询商品信息(商品服务)
        List<String> productIdList = orderDto.getOrderDetailList().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);
        log.info("[商品服务][查询商品]，response={}", productInfoList);
        // 2、计算总价
        BigDecimal totalAmount = new BigDecimal(0);
        for (ProductInfoOutput productInfo : productInfoList) {
            for (OrderDetail orderDetail : orderDto.getOrderDetailList()) {
                if (orderDetail.getProductId().equals(productInfo.getProductId())) {
                    // 单价*数量
                    totalAmount = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(totalAmount);
                    // 订单详情入库
                    orderDetail.setDetailId(KeyTool.getUniqueKey());
                    orderDetail.setOrderId(orderId);
                    orderDetail.setProductName(productInfo.getProductName());
                    orderDetail.setProductIcon(productInfo.getProductIcon());
                    orderDetail.setProductPrice(productInfo.getProductPrice());
                    orderDetailDao.save(orderDetail);
                }
            }

        }

        // 3、扣库存(商品服务)
        List<DecreaseStockInput> cartDtoList = orderDto.getOrderDetailList().stream()
                .map(item -> new DecreaseStockInput(item.getProductId(), item.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDtoList);
        // 4、订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDto.setOrderId(orderId);
        BeanUtils.copyProperties(orderDto, orderMaster);
        orderMaster.setOrderAmount(totalAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());
        orderMasterDao.save(orderMaster);

        return orderDto;
    }
}
