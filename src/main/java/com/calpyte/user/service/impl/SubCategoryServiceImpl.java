package com.calpyte.user.service.impl;

import com.calpyte.user.entity.SubCategory;
import com.calpyte.user.repository.SubCategoryRepository;
import com.calpyte.user.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public SubCategory saveSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public Map<String,String> findByCategoryId(String id) {
        List<SubCategory> subCategoryList = subCategoryRepository.findByCategoryId(id);
        Map<String,String> map = new HashMap<>();
        subCategoryList.forEach(list -> {
            map.put(list.getId(), list.getName());
        });
        return map;
    }
}
