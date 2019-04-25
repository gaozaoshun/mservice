package org.gfs.product.server.vo;

import lombok.Data;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.product.vo
 * @ClassName ResultVo
 * @description
 * @date created in 2019-04-15 11:31
 * @modified by
 */
@Data
public class ResultVo<T> {
    /** 错误码 */
    private Integer code;
    /** 提示信息 */
    private String msg;
    /** 具体信息 */
    private T data;
}
