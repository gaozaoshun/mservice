package org.gfs.order.server.model;


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
@Table(name = "product_info")
@Entity
@Data
public class ProductInfo {
    /** 商品ID */
    @Id
    private String productId;
    /** 商品名称 */
    private String productName;
    /** 商品单价 */
    private BigDecimal productPrice;
    /** 商品库存 */
    private Integer productStock;
    /** 商品描述 */
    private String productDescription;
    /** 商品图标URL */
    private String productIcon;
    /** 商品状态 0-正常 1-下架 */
    private Integer productStatus;
    /** 类目编号 */
    private Integer categoryType;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
