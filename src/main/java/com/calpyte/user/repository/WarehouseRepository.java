package com.calpyte.user.repository;


import com.calpyte.user.entity.Warehouse;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface WarehouseRepository extends MongoRepository<Warehouse, String>  {

}
