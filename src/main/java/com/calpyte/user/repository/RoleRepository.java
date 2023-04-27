package com.calpyte.user.repository;





import com.calpyte.user.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(String name);

//    Page<Role> findAll(Specification specifications, Pageable paging);
}
