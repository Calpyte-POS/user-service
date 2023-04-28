package com.calpyte.user.repository;

import com.calpyte.user.entity.Tenant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends MongoRepository<Tenant , String> {

    Page<Tenant> findAll(Pageable pageable);


}
