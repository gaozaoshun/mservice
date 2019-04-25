package org.gfs.order.server.exception;

import org.gfs.order.server.enums.HttpCodeEnum;
import org.gfs.order.server.enums.ResultCodeEnum;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.order.exception
 * @ClassName OrderException
 * @description
 * @date created in 2019-04-15 19:51
 * @modified by
 */
public class OrderException extends RuntimeException {
    private Integer code;


    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultCodeEnum code) {
        super(code.getMessage());
        this.code = code.getCode();
    }

    public OrderException(HttpCodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
    }
}
