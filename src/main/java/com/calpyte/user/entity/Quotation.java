package com.calpyte.user.entity;

import lombok.Data;

@Data
public class Quotation {

    private String id;
    private String name;
    private String date;
    private String warehouse;
    private String customer;
    private String product;
    private String orderTax;
    private String discount;
    private String shipping;
    private String status;
    private String notes;
}
