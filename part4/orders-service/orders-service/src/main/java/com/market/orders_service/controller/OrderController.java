package com.market.orders_service.controller;

import com.market.orders_service.model.Order;
import com.market.orders_service.model.Product;
import com.market.orders_service.model.UpdateOrderStatusRequest;
import com.market.orders_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getOrdersBySupplier(@RequestParam(required = false) Optional<Integer> supplierId) {
        if (supplierId != null)
            return ResponseEntity.ok(orderService.getOrdersBySupplier(supplierId.get()));
        return ResponseEntity.ok(orderService.getAllOrders());

    }

    @PostMapping()
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    //will be used by the market owner to accept status = completed and by the supplier to mark order as under status=pending
    @PatchMapping("/{id}/")
    public ResponseEntity<String> updateOrderStatus(@RequestBody UpdateOrderStatusRequest updateOrderStatusRequest, @PathVariable Integer id) {
        boolean isUpdated = orderService.updateOrderStatus(updateOrderStatusRequest.getStatusId(), id) == 1;
        if (isUpdated) {
            String respMsg = "סטטוס הזמנה עודכן בהצלחה!";
            return ResponseEntity.ok(respMsg);
        }
        String respMsg = "לא נמצאה הזמנה!";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respMsg);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> getOrderProducts(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrderProducts(id));
    }
}