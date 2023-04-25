package com.calpyte.user.dto.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TableResponseDTO {
    private Integer draw;
    private Object recordsTotal;
    private Object recordsFiltered;
    private List<?> data;
}
