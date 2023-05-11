package com.calpyte.user.repository;

import com.calpyte.user.entity.Adjustment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdjustmentRepository extends MongoRepository<Adjustment,String> {

    Adjustment findByReference(String reference);
}
