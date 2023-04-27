package com.calpyte.user.dao;


import com.calpyte.user.entity.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface WarehouseDAO {
    void save (Warehouse warehouse);

    Optional<Warehouse> findById(String id);


    Page findPagination(Pageable pageable);



}
