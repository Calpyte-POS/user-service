package com.calpyte.user.dto;

import lombok.Data;

@Data
public class WarehouseDTO {
    private String id;
    private  String name;
    private  String phoneNumber;
    private  String city;
    private  String country;
    private  String email;
    private  String zipCode;
    private Boolean isDeleted;
}
