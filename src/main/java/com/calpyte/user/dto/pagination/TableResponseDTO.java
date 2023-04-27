package com.calpyte.user.dto.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TableResponseDTO {
    private Integer draw;
    private Object recordsTotal;
    private Object recordsFiltered;
    private List<?> data;
}
