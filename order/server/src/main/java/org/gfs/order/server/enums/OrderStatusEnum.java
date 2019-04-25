package org.gfs.order.server.enums;

import lombok.Getter;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.order.enums
 * @ClassName OrderStatusEnum
 * @description
 * @date created in 2019-04-15 16:20
 * @modified by
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完成订单"),
    CENCEL(2, "取消订单"),
    ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
