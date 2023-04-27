package com.calpyte.user.repository;

import com.calpyte.user.entity.Tenant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantRepository extends MongoRepository<Tenant , String> {

    Page<Tenant> findAll(Pageable pageable);

//    @Query(fields="{ 'id' : 0}")
//    List<Tenant> findAllWithLimit(int limit);

}
