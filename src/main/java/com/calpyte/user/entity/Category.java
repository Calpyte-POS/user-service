package com.calpyte.user.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Category {
    @Id
    private String id;
    private String name;

    private String image;
}
