package com.calpyte.user.entity;

import com.calpyte.user.dto.BasicDTO;
import lombok.Data;

@Data
public class Product {
    private String name;
    private BasicDTO productCategory;
    private String code;
    private BasicDTO brand;
    private BasicDTO barcodeSymbology;
    private String productCost;
    private String productPrice;
    private String productUnit;
    private BasicDTO saleUnit;
    private BasicDTO purchaseUnit;
    private String stockAlert;
    private String orderTax;
    private BasicDTO taxType;
    private String quantityLimitation;
    private String multipleImage;
    private BasicDTO warehouse;
    private BasicDTO supplier;
    private String addProductQuantity;
    private String status;
    private String notes;

    private Boolean isDeleted;

}
