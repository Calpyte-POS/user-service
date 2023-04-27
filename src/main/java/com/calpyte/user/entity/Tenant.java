package com.calpyte.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class Tenant {
    @Id
    @GeneratedValue(generator = "custom-id-generator")
    @GenericGenerator(name = "custom-id-generator", strategy = "com.calpyte.user.entity.CustomIdGenerator")
    private String id;
    private String businessName;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedDate;

    private Boolean isBarORestaurant;
    private String defaultCategory;
    private String tax;

    private Boolean multiStore;
    private String multiStoreValue;

    private Boolean printReceipt;

    private Boolean printORReceipt;

    private Boolean paymentMethod;
    private Boolean acceptTips;
    private Boolean cashRounding;

    private Boolean printerSettings;
    private String ipAddress;
}
