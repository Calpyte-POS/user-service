package com.calpyte.user.repository;


import com.calpyte.user.entity.Capabilities;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CapabilitiesRepository extends MongoRepository<Capabilities, String> {
    Optional<Capabilities> findByName(String name);
}
