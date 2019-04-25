package org.gfs.order.server.enums;

import lombok.Getter;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.order.enums
 * @ClassName PayStatusEnum
 * @description
 * @date created in 2019-04-15 16:22
 * @modified by
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付完成"),
    ;
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
