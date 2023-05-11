package com.calpyte.user.repository;

import com.calpyte.user.entity.Images;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepository extends MongoRepository<Images,String> {
}
