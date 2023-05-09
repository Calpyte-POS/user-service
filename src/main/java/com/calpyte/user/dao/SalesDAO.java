package com.calpyte.user.dao;

import com.calpyte.user.entity.Sales;

import java.util.List;
import java.util.Optional;

public interface SalesDAO {
    Optional<Sales> findByName(String name);

    Sales save(Sales sales);

    List<Sales> getAllSales();

    Optional<Sales> findById(String id);
}
