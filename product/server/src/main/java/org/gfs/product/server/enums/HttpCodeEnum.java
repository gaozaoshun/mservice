package org.gfs.product.server.enums;

import lombok.Getter;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.product.enums
 * @ClassName HttpCodeEnum
 * @description
 * @date created in 2019-04-15 12:01
 * @modified by
 */
@Getter
public enum HttpCodeEnum {
    SUCCESS(0, "SUCCESS"),
    PARAM_ERROR(1,"参数错误"),
    ;
    private Integer code;
    private String message;

    HttpCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
