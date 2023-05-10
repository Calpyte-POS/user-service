package com.calpyte.user.dao.Impl;

import com.calpyte.user.dao.CustomerDAO;
import com.calpyte.user.entity.Customer;
import com.calpyte.user.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private CustomerRepository customerRepository;




    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
