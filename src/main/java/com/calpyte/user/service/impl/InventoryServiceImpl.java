package com.calpyte.user.service.impl;

import com.calpyte.user.entity.Inventory;
import com.calpyte.user.exceptions.CustomValidationException;
import com.calpyte.user.repository.InventoryRepository;
import com.calpyte.user.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;


    @Override
    public Inventory save(Inventory inventory) throws Exception {
        if(inventory.getId() != null ){
            Inventory inventoryExist = inventoryRepository.findById(inventory.getId()).orElse(null);
            if(inventoryExist != null){
                inventoryExist.setStock(inventory.getStock());
                inventoryExist.setPrice(inventory.getPrice());
                inventoryRepository.save(inventoryExist);
            }
            else throw  new Exception("No inventory Found");
        }
        else{
            inventoryRepository.save(inventory);
        }

           return inventory;
    }

    @Override
    public Inventory findByUserIdAndProductIdAndUserWarehouseId(String productId, String warehouseId) {
        return inventoryRepository.findByProductIdAndWarehouseId(productId, warehouseId);

    }

    @Override
    public List<Inventory> findByProductId(String productId) {
        return inventoryRepository.findByProductId(productId);
    }

    @Override
    public List<Inventory> findByWarehouseId(String warehouseId) {
        return inventoryRepository.findByProductId(warehouseId);
    }
}
