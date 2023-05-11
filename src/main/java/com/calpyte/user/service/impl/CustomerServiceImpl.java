package com.calpyte.user.service.impl;

import com.calpyte.user.dao.CustomerDAO;
import com.calpyte.user.entity.Customer;

import com.calpyte.user.exceptions.CustomValidationException;
import com.calpyte.user.service.CustomerService;
import com.calpyte.user.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;




    @Override
    public List<Customer> getAllCustomer() {
        return customerDAO.getAllCustomer();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        if (customer.getName() == null || customer.getName().trim().isEmpty() || customerDAO.findByName(customer.getName()).isPresent()) {
            throw new CustomValidationException("Customer name is not valid", HttpStatus.BAD_REQUEST);
        }
        return customerDAO.save(customer);
    }
}
