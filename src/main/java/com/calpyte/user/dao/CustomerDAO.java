package com.calpyte.user.dao;

import com.calpyte.user.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {


    List<Customer> getAllCustomer();

    Optional<Customer> findByName(String name);

    Customer save(Customer customer);
}
