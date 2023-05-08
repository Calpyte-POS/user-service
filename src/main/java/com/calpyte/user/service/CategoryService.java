package com.calpyte.user.service;

import com.calpyte.user.entity.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    Category saveCategory(Category category);

    Map<String , String> findAll();
}
