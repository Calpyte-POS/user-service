package com.calpyte.user.entity;

import com.calpyte.user.dto.BasicDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class SubCategory {

    @Id
    private String id;
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
    private BasicDTO warehouse;
    private BasicDTO supplier;
    private String addProductQuantity;
    private String status;
    private String notes;

    private Boolean isDeleted;

    private Category category;

    private String multipleImage;
}
