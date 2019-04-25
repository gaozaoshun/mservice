package org.gfs.product.server.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.gfs.product.server.model.ProductCategory;
import org.gfs.product.server.dao.ProductCategoryDao;
import org.gfs.product.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.product.service.impl
 * @ClassName CategoryServiceImpl
 * @description
 * @date created in 2019-04-15 11:25
 * @modified by
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryDao categoryDao;
    @Override
    public List<ProductCategory> findByTypeList(List<Integer> typeList) {
        return categoryDao.findByCategoryTypeIn(typeList);
    }
}
