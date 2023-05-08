package com.calpyte.user.service.impl;
import com.calpyte.user.Specification.BaseSpecification;
import com.calpyte.user.dao.ProductDAO;
import com.calpyte.user.dto.ProductDTO;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.SearchCriteria;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Product;
import com.calpyte.user.service.ProductService;
import com.calpyte.user.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;
    private List<SearchCriteria> params = new ArrayList<>();
    private final MongoTemplate mongoTemplate;
    public ProductServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO product)  {
        Product productObj = Mapper.map(product, Product.class);
        productObj.setIsDeleted(false);
        productDAO.save(productObj);
        return product;
    }
    @Override
    public ProductDTO findById(String id) {
        Optional<Product> productOptional = productDAO.findById(id);
        if (productOptional.isPresent()) {
            return Mapper.map(productOptional.get(), ProductDTO.class);
        }
        return null;
    }
    @Override
    public void delete(String id) {
        Optional<Product> productOpt = productDAO.findById(id);
        if (productOpt.isPresent()) {
            Product Product = productOpt.get();
            Product.setIsDeleted(true);
            productDAO.save(Product);
        }
    }
    @Override
    public TableResponseDTO getProducts(PaginationDTO pagination) {
        TableResponseDTO response;
        BaseSpecification productSpecification = new BaseSpecification(mongoTemplate);
        Pageable paging = PageRequest.of(pagination.getPageNo() - 1, pagination.getPageSize());
        params.clear();
        List<SearchCriteria> searchCriteria = pagination.getFilter();
        Page<Product> productPage = productSpecification.getAll(searchCriteria,paging,Product.class);
        if (productPage.hasContent()) {
            List<Product> warehouseList = productPage.getContent();
            response = new TableResponseDTO(0, (int) productPage.getTotalElements(), (int) productPage.getTotalElements(),
                    warehouseList);
        } else {
            response = new TableResponseDTO(0, (int) productPage.getTotalElements(), (int) productPage.getTotalElements(),
                    new ArrayList<>());
        }
        return response;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
}
