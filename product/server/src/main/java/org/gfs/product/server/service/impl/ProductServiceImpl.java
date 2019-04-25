package org.gfs.product.server.service.impl;

import org.gfs.product.common.DecreaseStockInput;
import org.gfs.product.server.dao.ProductInfoDao;
import org.gfs.product.server.dto.CartDto;
import org.gfs.product.server.enums.ProductStatusEnum;
import org.gfs.product.server.enums.ResultCodeEnum;
import org.gfs.product.server.exception.ProductException;
import org.gfs.product.server.model.ProductInfo;
import org.gfs.product.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.product.service.impl
 * @ClassName ProductServiceImpl
 * @description
 * @date created in 2019-04-15 10:53
 * @modified by
 */
@Service

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoDao.findByProductIdIn(productIdList);
    }

    /**
     * 扣库存
     *
     * @param cartDtoList
     */
    @Override
    @Transactional
    public void descreaseStock(List<DecreaseStockInput> cartDtoList) {

        for (DecreaseStockInput cartDto : cartDtoList) {
            Optional<ProductInfo> optional = productInfoDao.findById(cartDto.getProductId());
            // 检查是否存在商品
            if (!optional.isPresent()) {
                throw new ProductException(ResultCodeEnum.PRODUCT_NOT_EXITED);
            }
            // 库存是否足够
            ProductInfo productInfo = optional.get();
            Integer count = productInfo.getProductStock() - cartDto.getProductQuantity();
            if (count < 0) {
                throw new ProductException(ResultCodeEnum.PRODUCT_NOT_STOCK);
            }
            productInfo.setProductStock(count);
            // 扣库存
            productInfo.setUpdateTime(new Date());
            productInfoDao.save(productInfo);
        }

    }
}
