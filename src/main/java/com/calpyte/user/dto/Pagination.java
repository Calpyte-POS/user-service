package com.calpyte.user.dto;

import lombok.Data;

@Data
public class Pagination {
    private Integer page;
    private Integer size;
    private String sort;
}
