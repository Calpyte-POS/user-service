package com.calpyte.user.dao.Impl;

import com.calpyte.user.dao.SalesDAO;
import com.calpyte.user.entity.Sales;
import com.calpyte.user.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SalesDAOImpl implements SalesDAO {

    @Autowired
    private SalesRepository salesRepository;

    @Override
    public Optional<Sales> findByName(String name) {
        return salesRepository.findByName(name);
    }

    @Override
    public Sales save(Sales sales) {
        return salesRepository.save(sales);
    }

    @Override
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @Override
    public Optional<Sales> findById(String id) {
        return salesRepository.findById(id);
    }
}
