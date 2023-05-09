package com.calpyte.user.repository;


import com.calpyte.user.entity.Sales;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalesRepository extends MongoRepository<Sales, String> {
    Optional<Sales> findByName(String name);
}
