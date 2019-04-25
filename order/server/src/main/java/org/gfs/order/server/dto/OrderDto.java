package org.gfs.order.server.dto;

import lombok.Data;
import org.gfs.order.server.model.OrderDetail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.order.dto
 * @ClassName OrderDto
 * @description
 * @date created in 2019-04-15 16:54
 * @modified by
 */
@Data
public class OrderDto {

    /** 订单id. */
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;

    private List<OrderDetail> orderDetailList;
}
