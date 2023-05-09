package com.calpyte.user.entity;

import com.calpyte.user.dto.BasicDTO;
import lombok.Data;

@Data
public class Sales {

    private String id;
    private String name;
    private String price;
    private String qty;
    private String total;

    private BasicDTO SubCategory;
}
