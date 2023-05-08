package com.calpyte.user.service.impl;

import com.calpyte.user.Specification.BaseSpecification;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.SearchCriteria;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.SubCategory;
import com.calpyte.user.entity.Warehouse;
import com.calpyte.user.repository.SubCategoryRepository;
import com.calpyte.user.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    private List<SearchCriteria> params = new ArrayList<>();
    private final MongoTemplate mongoTemplate;
    public SubCategoryServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

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

    @Override
    public void delete(String id) {
        Optional<SubCategory> subCategoryOpt = subCategoryRepository.findById(id);
        if (subCategoryOpt.isPresent()) {
            SubCategory subCategory = subCategoryOpt.get();
            subCategory.setIsDeleted(true);
            subCategoryRepository.save(subCategory);
        }
    }

    @Override
    public TableResponseDTO getSubCategories(PaginationDTO pagination) {
        TableResponseDTO response;
        BaseSpecification subCategorySpecification = new BaseSpecification(mongoTemplate);
        Pageable paging = PageRequest.of(pagination.getPageNo() - 1, pagination.getPageSize());
        params.clear();
        List<SearchCriteria> searchCriteria = pagination.getFilter();
        Page<SubCategory> subCategoryPage = subCategorySpecification.getAll(searchCriteria,paging,SubCategory.class);
        if (subCategoryPage.hasContent()) {
            List<SubCategory> warehouseList = subCategoryPage.getContent();
            response = new TableResponseDTO(0, (int) subCategoryPage.getTotalElements(), (int) subCategoryPage.getTotalElements(),
                    warehouseList);
        } else {
            response = new TableResponseDTO(0, (int) subCategoryPage.getTotalElements(), (int) subCategoryPage.getTotalElements(),
                    new ArrayList<>());
        }
        return response;
    }
}
