package org.gfs.product.server.enums;

import lombok.Getter;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.product.enums
 * @ClassName ResultCodeEnum
 * @description
 * @date created in 2019-04-16 17:43
 * @modified by
 */
@Getter
public enum ResultCodeEnum {
    PRODUCT_NOT_EXITED(1,"商品不存在"),
    PRODUCT_NOT_STOCK(2,"商品库存不足"),
    ;
    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
