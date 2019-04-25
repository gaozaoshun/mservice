package org.gfs.product.server.service;

import org.gfs.product.server.model.ProductCategory;

import java.util.List;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.product.service
 * @ClassName CategoryService
 * @description
 * @date created in 2019-04-15 11:25
 * @modified by
 */
public interface CategoryService {

    List<ProductCategory> findByTypeList(List<Integer> typeList);
}
