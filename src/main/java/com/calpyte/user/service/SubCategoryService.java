package com.calpyte.user.service;

import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.SubCategory;

import java.util.List;
import java.util.Map;

public interface SubCategoryService {
    void delete(String id);

    SubCategory saveSubCategory(SubCategory subCategory);

    Map<String,String> findByCategoryId(String id);

    public TableResponseDTO getSubCategories(PaginationDTO pagination);
}
