package com.calpyte.user.service;

import com.calpyte.user.dto.WarehouseDTO;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;

public interface WarehouseService {
    WarehouseDTO saveWarehouse(WarehouseDTO warehouse) ;


    WarehouseDTO findById(String id);


    void delete(String id);


    public TableResponseDTO getWarehouses(PaginationDTO pagination);
}
