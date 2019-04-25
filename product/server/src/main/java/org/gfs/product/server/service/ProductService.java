package org.gfs.product.server.service;

import org.gfs.product.common.DecreaseStockInput;
import org.gfs.product.server.dto.CartDto;
import org.gfs.product.server.model.ProductInfo;

import java.util.List;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.product.service
 * @ClassName ProductService
 * @description
 * @date created in 2019-04-15 10:52
 * @modified by
 */
public interface ProductService {
    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDtoList
     */
    void descreaseStock(List<DecreaseStockInput> cartDtoList);
}
