package org.gfs.product.server.dto;

import lombok.Data;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.product.dto
 * @ClassName CartDto
 * @description
 * @date created in 2019-04-16 17:18
 * @modified by
 */
@Data
public class CartDto {
    /**
     * 商品ID
     */
    private String productId;
    /**
     * 数量
     */
    private Integer productQuantity;
}
