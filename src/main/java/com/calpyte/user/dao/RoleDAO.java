package com.calpyte.user.dao;


import com.calpyte.user.entity.Role;



import java.util.List;
import java.util.Optional;

public interface RoleDAO {
    Optional<Role> findByName(String name);

    Role save(Role role);


    List<Role> getAllRoles();

    Optional<Role> findById(String id);
}
