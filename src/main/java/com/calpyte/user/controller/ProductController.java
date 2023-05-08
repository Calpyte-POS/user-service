package com.calpyte.user.controller;

import com.calpyte.user.dto.ProductDTO;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Product;
import com.calpyte.user.entity.Role;
import com.calpyte.user.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/save")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<ProductDTO> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<ProductDTO> delete(@RequestParam("id") String id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<TableResponseDTO> getProducts(@RequestBody PaginationDTO pagination){
        return new ResponseEntity<>(productService.getProducts(pagination), HttpStatus.ACCEPTED);
    }
    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
