package com.calpyte.user.repository;

import com.calpyte.user.entity.Quotation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuotationRepository extends MongoRepository<Quotation, String> {
    Optional<Quotation> findByName(String name);
}
