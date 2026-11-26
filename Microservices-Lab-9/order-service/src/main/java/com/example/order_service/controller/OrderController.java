package com.example.order_service.controller;

import com.example.order_service.model.Order;
import com.example.order_service.service.OrderService;
import com.example.order_service.dto.CustomerOrdersResponse;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Create order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // Get all orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Get order by ID
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Update order
    @PutMapping("/{id}")
    public Order updateOrder(
            @PathVariable Long id,
            @RequestBody Order order) {

        return orderService.updateOrder(id, order);
    }

    // Delete order
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {

        orderService.deleteOrder(id);

        return "Order deleted successfully";
    }

    // Get customer with all their orders
    @GetMapping("/customer/{customerId}")
    public CustomerOrdersResponse getOrdersByCustomer(
            @PathVariable Long customerId) {

        return orderService.getOrdersByCustomer(customerId);
    }
}