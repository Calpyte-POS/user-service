package com.calpyte.user.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TableResponse {
    private Integer draw;
    private Object recordsTotal;
    private Object recordsFiltered;
    private List<?> data;
}
