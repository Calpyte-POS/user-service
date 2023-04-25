package com.calpyte.user.dto.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
    private Boolean orPredicate;
    private List<Object> values;
    public boolean isOrPredicate() {
        if(orPredicate == null) return  false;
        return orPredicate;
    }
    public void setOrPredicate(boolean orPredicate) {
        this.orPredicate = orPredicate;
    }
}
