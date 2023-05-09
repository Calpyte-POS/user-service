package com.calpyte.user.service;

import com.calpyte.user.entity.Sales;

import java.util.List;

public interface SalesService {
    Sales saveSales(Sales sales);

    List<Sales> getAllSales();

    Sales findById(String id);

    void delete(String id);
}
