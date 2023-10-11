package com.example.servlet.dao;

import com.example.servlet.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    void createCustomer(Customer customer);
    List<Customer> getAllCustomer();
}