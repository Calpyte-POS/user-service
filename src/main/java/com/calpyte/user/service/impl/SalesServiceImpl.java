package com.calpyte.user.service.impl;

import com.calpyte.user.dao.SalesDAO;
import com.calpyte.user.entity.Role;
import com.calpyte.user.entity.Sales;
import com.calpyte.user.exceptions.CustomValidationException;
import com.calpyte.user.service.SalesService;
import com.calpyte.user.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesDAO salesDAO;

    @Override
    public Sales saveSales(Sales sales) {
        if (sales.getName() == null || sales.getName().trim().isEmpty() || salesDAO.findByName(sales.getName()).isPresent()) {
            throw new CustomValidationException("Sales name is not valid", HttpStatus.BAD_REQUEST);
        }
        return salesDAO.save(sales);
    }

    @Override
    public List<Sales> getAllSales() {
         return salesDAO.getAllSales();
    }

    @Override
    public Sales findById(String id) {
        Optional<Sales> salesOptional = salesDAO.findById(id);
        if (salesOptional.isPresent()) {
            return Mapper.map(salesOptional.get(), Sales.class);
        }
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
