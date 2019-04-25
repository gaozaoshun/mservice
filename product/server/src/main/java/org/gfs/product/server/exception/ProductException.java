package org.gfs.product.server.exception;

import org.gfs.product.server.enums.ResultCodeEnum;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.product
 * @ClassName ProductException
 * @description
 * @date created in 2019-04-16 17:31
 * @modified by
 */
public class ProductException extends RuntimeException {
    private Integer code;


    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = code;
    }
}
