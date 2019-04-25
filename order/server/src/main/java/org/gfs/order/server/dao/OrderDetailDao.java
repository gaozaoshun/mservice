package org.gfs.order.server.dao;

import org.gfs.order.server.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.order.dao
 * @ClassName OrderDetailDao
 * @description
 * @date created in 2019-04-15 14:49
 * @modified by
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {
}
