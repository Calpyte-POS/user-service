package com.calpyte.user.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Inventory {

    @Id
    private String id;
    private String warehouseId;
    private String productId;
    private Double stock;
    private Double price;

}
