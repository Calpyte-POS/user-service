package com.calpyte.user.dao;


import com.calpyte.user.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface RoleDAO {
    Optional<Role> findByName(String name);

    List<Role> saveAll(List<Role> roles);

    Role save(Role role);

    Optional<Role> findById(String id);

    public Page<Role> findPagination(Pageable pageable);

    List<Role> findAll();

}   
