package com.calpyte.user.controller;


import com.calpyte.user.dto.WarehouseDTO;


import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import org.springframework.web.bind.annotation.*;
import com.calpyte.user.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;


    @PostMapping(value = "/save")
    public ResponseEntity<WarehouseDTO> saveWarehouse(@RequestBody WarehouseDTO warehouse) {
        return new ResponseEntity<>(warehouseService.saveWarehouse(warehouse), HttpStatus.CREATED);
    }


    @GetMapping(value = "/by-id")
    public ResponseEntity<WarehouseDTO> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(warehouseService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<WarehouseDTO> delete(@RequestParam("id") String id){
        warehouseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping(value = "")
    public ResponseEntity<TableResponseDTO> getWarehouses(@RequestBody PaginationDTO pagination){
        return new ResponseEntity<>(warehouseService.getWarehouses(pagination), HttpStatus.ACCEPTED);
    }
}
