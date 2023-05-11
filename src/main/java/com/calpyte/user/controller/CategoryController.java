package com.calpyte.user.controller;

import com.calpyte.user.entity.Category;
import com.calpyte.user.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save")
    public String saveCategory(MultipartFile file) throws IOException {
        String id = categoryService.saveCategory(file);
//        return ResponseEntity<String>(categoryService.saveCategory(name,  file));
        return "redirect:/category/" + id;
    }

    @GetMapping("/photos/{id}")
    public String getPhoto(@PathVariable String id, Model model) {
        Category category = categoryService.getImage(id);
        model.addAttribute("name", category.getName());
        model.addAttribute("image",
                Base64.getEncoder().encodeToString(category.getImage().getData()));
        return "photos";
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String , String>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }
}
