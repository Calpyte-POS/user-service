package com.calpyte.user.service;

import com.calpyte.user.entity.SubCategory;

import java.util.List;
import java.util.Map;

public interface SubCategoryService {
    SubCategory saveSubCategory(SubCategory subCategory);

    Map<String,String> findByCategoryId(String id);
}
