package com.calpyte.user.service;

import com.calpyte.user.entity.Inventory;

import java.util.List;

public interface InventoryService {
    Inventory save(Inventory inventory) throws Exception;

    Inventory findByUserIdAndProductIdAndUserWarehouseId(String productId, String warehouseId);

    List<Inventory> findByProductId(String productId);

    List<Inventory> findByWarehouseId(String warehouseId);
}
