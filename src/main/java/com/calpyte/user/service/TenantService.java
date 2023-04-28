package com.calpyte.user.service;

import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Tenant;

public interface TenantService {

    Tenant saveTenant(Tenant tenant);

    TableResponseDTO getAll(PaginationDTO pagination);
}
