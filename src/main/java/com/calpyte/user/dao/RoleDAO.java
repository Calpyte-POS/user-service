package com.calpyte.user.dao;


import com.calpyte.user.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import java.util.Optional;

public interface RoleDAO {
    Optional<Role> findByName(String name);

    Role save(Role role);

    public Page<Role> findPagination(Pageable pageable);

}   
