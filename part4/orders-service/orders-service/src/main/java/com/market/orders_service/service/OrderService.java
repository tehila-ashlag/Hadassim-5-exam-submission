package com.market.orders_service.service;

import com.market.orders_service.model.Order;
import com.market.orders_service.model.Product;
import com.market.orders_service.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.market.orders_service.util.Util.Status.PENDING_SUPLIER_APPROVAL;
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public List<Order> getOrdersBySupplier(Integer supplierId){
        return orderRepository.findOrdersByStatus_IdAndSupplier_Id(PENDING_SUPLIER_APPROVAL.getCode(),supplierId);
    }

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    //will be used by the market owner to accept order = completed and by the supplier to mark order as under handlement=pending
    public int updateOrderStatus(Integer statusId,Integer id){
        return orderRepository.updateOrderStatus(statusId,id);
    }

    public List<Product> getOrderProducts(Integer id){
        return orderRepository.findById(id).get().getProductList();
    }

}
