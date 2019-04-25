package org.gfs.product.server.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.product.model
 * @ClassName ProductInfo
 * @description 商品信息
 * @date created in 2019-04-15 10:19
 * @modified by
 */
@Table(name = "product_category")
@Entity
@Data
public class ProductCategory {
    /** 商品ID */
    @Id
    private Integer categoryId;
    /** 类目名字 */
    private String categoryName;
    /** 类目编号 */
    private Integer categoryType;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
