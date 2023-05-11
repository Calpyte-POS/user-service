package com.calpyte.user.controller;

import com.calpyte.user.dto.WarehouseDTO;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.SubCategory;
import com.calpyte.user.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sub-category")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping("")
    public ResponseEntity<SubCategory> saveSubCategory(@RequestBody SubCategory subCategory){
        return ResponseEntity.ok(subCategoryService.saveSubCategory(subCategory));
    }

    @GetMapping("/by-category")
    public ResponseEntity<Map<String,String>> findByCategory(@RequestParam("id") String id){
        return ResponseEntity.ok(subCategoryService.findByCategoryId(id));
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<WarehouseDTO> delete(@RequestParam("id") String id){
        subCategoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "get-all")
    public ResponseEntity<List<SubCategory>> findAll() { return new ResponseEntity<>(subCategoryService.findAll(), HttpStatus.OK); }


    @PostMapping(value = "/getSubCategories")
    public ResponseEntity<TableResponseDTO> getSubCategories(@RequestBody PaginationDTO pagination){
        return new ResponseEntity<>(subCategoryService.getSubCategories(pagination), HttpStatus.ACCEPTED);
    }
}
