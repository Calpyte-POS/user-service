package com.calpyte.user.service;

import com.calpyte.user.dto.ProductDTO;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDTO saveProduct(ProductDTO product) ;

    ProductDTO findById(String id);

    void delete(String id);

    public TableResponseDTO getProducts(PaginationDTO pagination);

   List<Product> getAllProducts();
}
