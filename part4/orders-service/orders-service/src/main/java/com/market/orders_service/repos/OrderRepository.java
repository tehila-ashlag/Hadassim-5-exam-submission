package com.market.orders_service.repos;

import com.market.orders_service.model.Order;
import com.market.orders_service.model.Status;
import com.market.orders_service.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Transactional
    @Modifying
    @Query("update Order o set o.status.id = ?1 where o.id = ?2")
    int updateOrderStatus(Integer statusId, Integer id);
    List<Order> findOrdersByStatus_IdAndSupplier_Id(Integer status, Integer supplier);
}
