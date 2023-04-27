package com.calpyte.user.dao.Impl;


import com.calpyte.user.dao.WarehouseDAO;

import com.calpyte.user.entity.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.calpyte.user.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class WarehouseDaoImpl implements WarehouseDAO {


    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public void save(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    @Override
    public Optional<Warehouse> findById(String id) {
        return warehouseRepository.findById(id);
    }

    @Override
    public Page<Warehouse> findPagination(Pageable pageable) {
        return warehouseRepository.findAll(pageable);
    }


}
