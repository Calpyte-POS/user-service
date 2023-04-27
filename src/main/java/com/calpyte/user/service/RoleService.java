package com.calpyte.user.service;


import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Role;


public interface RoleService {

    Role saveRole(Role role);

    TableResponseDTO getRoles(PaginationDTO pagination);
}
