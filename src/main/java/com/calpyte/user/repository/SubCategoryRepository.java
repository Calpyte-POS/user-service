package com.calpyte.user.repository;

import com.calpyte.user.entity.SubCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SubCategoryRepository extends MongoRepository<SubCategory,String> {

    List<SubCategory> findByCategoryId(String id);
}
