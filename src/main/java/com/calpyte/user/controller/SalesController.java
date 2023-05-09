package com.calpyte.user.controller;


import com.calpyte.user.entity.Sales;
import com.calpyte.user.service.SalesService;
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
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @PostMapping("/save")
    private ResponseEntity<Sales> saveSales(@RequestBody Sales sales){
        return ResponseEntity.ok(salesService.saveSales(sales));
    }

    @GetMapping("")
    public ResponseEntity<List<Sales>> getAllSales() {
        return ResponseEntity.ok(salesService.getAllSales());
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<Sales> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(salesService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<Sales> delete(@RequestParam("id") String id){
        salesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
