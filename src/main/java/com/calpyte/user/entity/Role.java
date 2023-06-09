package com.calpyte.user.entity;

import lombok.Data;

import java.util.List;

@Data
public class Role {

    private String id;
    private String name;
    private Boolean isDeleted;
    private List<Menu> menus;
}
