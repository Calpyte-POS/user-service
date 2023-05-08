package com.calpyte.user.service;


import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Role;

import java.util.List;


public interface RoleService {

    Role saveRole(Role role);

    List<Role> saveAllRoles(List<Role> role);

    Role findById(String id);

    void delete(String id);

    TableResponseDTO getRoles(PaginationDTO pagination);

    List<Role> findAll();

    List<Role> getAllRoles();
}
