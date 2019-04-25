package org.gfs.order.server.tool;

import org.gfs.order.server.enums.HttpCodeEnum;
import org.gfs.order.server.vo.ResultVo;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.product.tool
 * @ClassName HttpResultTool
 * @description
 * @date created in 2019-04-15 11:57
 * @modified by
 */
public final class HttpResultTool {

    public static <T> ResultVo<T> success(T data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(HttpCodeEnum.SUCCESS.getCode());
        resultVo.setMsg(HttpCodeEnum.SUCCESS.getMessage());
        resultVo.setData(data);
        return resultVo;
    }
}
