package com.calpyte.user.repository;





import com.calpyte.user.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(String name);

    @Query(value = "{ 'isDeleted' : {$eq: false}}")
    Page<Role> findAll(Pageable pageable);

}
