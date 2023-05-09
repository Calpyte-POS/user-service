package com.calpyte.user.controller;

import com.calpyte.user.entity.Inventory;
import com.calpyte.user.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;


    @PostMapping("/save")
    public ResponseEntity<Inventory> save(@RequestBody Inventory inventory) throws Exception {
        return new ResponseEntity<>(inventoryService.save(inventory), HttpStatus.CREATED);
    }

    @GetMapping("/by-id")
    public ResponseEntity<Inventory> findByUserId(@RequestParam("product") String productId , @RequestParam("warehouse") String warehouseId){
        return new ResponseEntity<>(inventoryService.findByUserIdAndProductIdAndUserWarehouseId(productId, warehouseId),HttpStatus.OK);
    }

    @GetMapping("/by-product")
    public ResponseEntity<List<Inventory>> findByProduct(@RequestParam("product") String productId){
        return new ResponseEntity<>(inventoryService.findByProductId(productId),HttpStatus.OK);
    }

    @GetMapping("/by-address")
    public ResponseEntity<List<Inventory>> findByWarehouse(@RequestParam("warehouse") String warehouse){
        return new ResponseEntity<>(inventoryService.findByWarehouseId(warehouse),HttpStatus.OK);
    }



}
