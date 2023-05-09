package com.calpyte.user.repository;

import com.calpyte.user.entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository  extends MongoRepository<Inventory, String> {

    Inventory findByProductIdAndWarehouseId(String productId, String warehouseId);

    List<Inventory> findByProductId(String productId);
}
