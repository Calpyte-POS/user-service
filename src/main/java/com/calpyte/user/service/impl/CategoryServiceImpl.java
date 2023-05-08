package com.calpyte.user.service.impl;

import com.calpyte.user.entity.Category;
import com.calpyte.user.repository.CategoryRepository;
import com.calpyte.user.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Map<String , String> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        Map<String , String> map = new HashMap<>();
        categoryList.forEach(list -> {
            map.put(list.getId(), list.getName());
        });
        return map;
    }
}
