package com.calpyte.user.Dao;

import com.calpyte.user.domain.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface WarehouseDAO {
    void save (Warehouse warehouse);

    Optional<Warehouse> findById(String id);


    Page findPagination(Pageable pageable);



}
