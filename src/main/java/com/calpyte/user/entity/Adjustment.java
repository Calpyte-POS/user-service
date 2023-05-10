package com.calpyte.user.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class Adjustment {
    @Id
    @GeneratedValue(generator = "custom-id-generator")
    @GenericGenerator(name = "custom-id-generator", strategy = "com.calpyte.user.entity.CustomIdGenerator")
    private String id;
    private String warehouse;
    private Date date;
    private String  reference;
    @OneToMany(fetch = FetchType.LAZY)
    private List<AdjustmentDetail> adjustmentDetail;

    private Inventory inventory;

}
