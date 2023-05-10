package com.calpyte.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
public class AdjustmentDetail {

    @Id
    @GeneratedValue(generator = "custom-id-generator")
    @GenericGenerator(name = "custom-id-generator", strategy = "com.calpyte.user.entity.CustomIdGenerator")
    private String id;

    private String product;
    private String qty;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adjustment")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Adjustment adjustment;
}
