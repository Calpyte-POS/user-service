package com.calpyte.user.service;

import com.calpyte.user.entity.Category;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CategoryService {
    String saveCategory(MultipartFile file) throws IOException;

    Map<String , String> findAll();

    Category getImage(String id);
}
