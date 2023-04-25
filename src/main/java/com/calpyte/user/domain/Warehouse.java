package com.calpyte.user.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
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
