package com.example.order_service.dto;

import com.example.order_service.model.Order;
import lombok.Data;

import java.util.List;

@Data
public class CustomerOrdersResponse {

    private Long customerId;

    private String name;

    private String email;

    private List<Order> orders;
}