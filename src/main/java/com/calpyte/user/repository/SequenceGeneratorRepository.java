package com.calpyte.user.repository;

import com.calpyte.user.entity.SequenceGenerator;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SequenceGeneratorRepository extends MongoRepository<SequenceGenerator, String> {
    SequenceGenerator findByid(String id);
}
