package com.calpyte.user.service;

import com.calpyte.user.entity.Customer;

import java.util.List;

public interface CustomerService {


    List<Customer> getAllCustomer();

    Customer saveCustomer(Customer customer);
}
