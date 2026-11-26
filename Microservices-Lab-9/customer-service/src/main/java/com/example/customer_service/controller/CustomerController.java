package com.example.customer_service.controller;

import com.example.customer_service.model.Customer;
import com.example.customer_service.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Create customer
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    // Get all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    // Update customer
    @PutMapping("/{id}")
    public Customer updateCustomer(
            @PathVariable Long id,
            @RequestBody Customer customer) {

        return customerService.updateCustomer(id, customer);
    }

    // Delete customer
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully";
    }
}

