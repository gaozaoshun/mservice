package org.gfs.product.server.controller;

import org.gfs.product.common.DecreaseStockInput;
import org.gfs.product.server.dto.CartDto;
import org.gfs.product.server.model.ProductCategory;
import org.gfs.product.server.model.ProductInfo;
import org.gfs.product.server.service.CategoryService;
import org.gfs.product.server.service.ProductService;
import org.gfs.product.server.tool.HttpResultTool;
import org.gfs.product.server.vo.ProductInfoVo;
import org.gfs.product.server.vo.ProductVo;
import org.gfs.product.server.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品信息
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 商品列表
     */
    @GetMapping("/list")
    public ResultVo<List<ProductVo>> list() {
        // 所有上架商品列表
        List<ProductInfo> productInfoList = productService.findUpAll();
        // 提取类目列表
        List<Integer> typeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        // 查询类目列表
        List<ProductCategory> categoryList = categoryService.findByTypeList(typeList);
        // 构造数据
        List<ProductVo> productVoList = new ArrayList<>();
        for (ProductCategory category : categoryList) {
            ProductVo productVo = new ProductVo();
            productVo.setCategoryType(category.getCategoryType());
            productVo.setCategoryName(category.getCategoryName());
            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(category.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);
        }
        return HttpResultTool.success(productVoList);
    }

    /**
     * 查询商品信息
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){
        return productService.findList(productIdList);
    }

    /**
     * 扣库存
     * @param cartDtoList
     * @return
     */
    @PostMapping("/decreaseStock")
    public ResultVo decreaseStock(@RequestBody List<DecreaseStockInput> cartDtoList){
        productService.descreaseStock(cartDtoList);
        return HttpResultTool.success("OK");
    }
}
