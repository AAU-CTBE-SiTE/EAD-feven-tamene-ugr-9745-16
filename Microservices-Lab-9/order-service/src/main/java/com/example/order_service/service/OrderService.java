package com.example.order_service.service;

import com.example.order_service.dto.CustomerOrdersResponse;
import com.example.order_service.dto.CustomerResponse;
import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestClient restClient;

    public OrderService(OrderRepository orderRepository,
                        RestClient restClient) {
        this.orderRepository = orderRepository;
        this.restClient = restClient;
    }

    // Check whether the customer exists
    public CustomerResponse getCustomer(Long customerId) {

        return restClient.get()
                .uri("/api/customers/{id}", customerId)
                .retrieve()
                .body(CustomerResponse.class);
    }

    // Create order
    public Order createOrder(Order order) {

        getCustomer(order.getCustomerId());

        return orderRepository.save(order);
    }

    // Get all orders
    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    // Get order by ID
    public Order getOrderById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));
    }

    // Update order
    public Order updateOrder(Long id, Order order) {

        Order existingOrder = getOrderById(id);

        getCustomer(order.getCustomerId());

        existingOrder.setProductName(order.getProductName());
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setCustomerId(order.getCustomerId());

        return orderRepository.save(existingOrder);
    }

    // Delete order
    public void deleteOrder(Long id) {

        Order existingOrder = getOrderById(id);

        orderRepository.delete(existingOrder);
    }

    // Get customer information with all their orders
    public CustomerOrdersResponse getOrdersByCustomer(Long customerId) {

        CustomerResponse customer = getCustomer(customerId);

        List<Order> orders =
                orderRepository.findByCustomerId(customerId);

        CustomerOrdersResponse response =
                new CustomerOrdersResponse();

        response.setCustomerId(customer.getId());
        response.setName(customer.getName());
        response.setEmail(customer.getEmail());
        response.setOrders(orders);

        return response;
    }
}