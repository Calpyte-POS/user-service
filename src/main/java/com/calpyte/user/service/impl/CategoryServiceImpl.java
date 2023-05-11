package com.calpyte.user.service.impl;

import com.calpyte.user.entity.Category;
import com.calpyte.user.repository.CategoryRepository;
import com.calpyte.user.service.CategoryService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public String saveCategory(MultipartFile file) throws IOException {
        Category category = new Category();
        category.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes())
        );
        category = categoryRepository.insert(category);
        return  category.getId();
    }

    @Override
    public Category getImage(String id) {
        return categoryRepository.findById(id).get();
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
