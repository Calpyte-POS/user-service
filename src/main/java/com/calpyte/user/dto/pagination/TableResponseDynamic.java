package com.calpyte.user.dto.pagination;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class    TableResponseDynamic {
    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    private List<?> data;
    private Boolean isAddBtn = false;
    private String route;
}