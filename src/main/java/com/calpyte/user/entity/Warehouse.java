package com.calpyte.user.entity;

import lombok.Data;


@Data

public class Warehouse {
    private String id;

    private  String name;
    private  String phoneNumber;
    private  String city;
    private  String country;
    private  String email;
    private  String zipCode;
    private Boolean isDeleted;
}
