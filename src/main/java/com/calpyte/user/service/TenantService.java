package com.calpyte.user.service;

import com.calpyte.user.dto.Pagination;
import com.calpyte.user.entity.Tenant;
import com.calpyte.user.utils.TableResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TenantService {

    Tenant saveTenant(Tenant tenant);

    TableResponse getAll(Pagination pagination);
}
