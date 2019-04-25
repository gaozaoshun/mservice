package org.gfs.order.server.enums;

import lombok.Getter;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.order.enums
 * @ClassName ResultCodeEnum
 * @description
 * @date created in 2019-04-16 17:57
 * @modified by
 */
@Getter
public enum ResultCodeEnum {
    CART_EMPTY(1, "购物车为空"),
    ;
    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
