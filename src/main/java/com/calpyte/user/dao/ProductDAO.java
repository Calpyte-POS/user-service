package com.calpyte.user.dao;

import com.calpyte.user.entity.Product;
import com.calpyte.user.entity.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    void save (Product product);
    Optional<Product> findById(String id);
    Page findPagination(Pageable pageable);

    List<Product> getAllProducts();
}
