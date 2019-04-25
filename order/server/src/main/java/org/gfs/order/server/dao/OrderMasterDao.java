package org.gfs.order.server.dao;

import org.gfs.order.server.model.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author gaozaoshun
 * @ProjectName microservice
 * @Package org.gfs.microservice.order.dao
 * @ClassName OrderMasterDao
 * @description
 * @date created in 2019-04-15 14:48
 * @modified by
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {
}
