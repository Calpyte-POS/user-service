package com.calpyte.user.service.impl;

import com.calpyte.user.Specification.BaseSpecification;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.SearchCriteria;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Tenant;
import com.calpyte.user.repository.TenantRepository;
import com.calpyte.user.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    private MongoTemplate mongoTemplate;

    @Override
    public Tenant saveTenant(Tenant tenant) {
        Tenant tenantExist = tenantRepository.findById(tenant.getId()).get();
        if(!ObjectUtils.isEmpty(tenantExist)){
            tenantExist.setUpdatedDate(new Date());
            tenantRepository.save(tenantExist);
            return tenantExist;
        }
        else {
            tenant.setCreatedDate(new Date());
            tenant.setUpdatedDate(new Date());
            return tenantRepository.save(tenant);
        }
    }

    @Override
    public TableResponseDTO getAll(PaginationDTO pagination) {
        TableResponseDTO response;
        BaseSpecification<Tenant> specification = new BaseSpecification<>(mongoTemplate);
        Pageable paging = PageRequest.of(pagination.getPageNo() - 1, pagination.getPageSize());
        List<SearchCriteria> searchCriteria = pagination.getFilter();
        Page<Tenant> tenantsList = specification.getAll(searchCriteria,paging,Tenant.class);
        if (tenantsList.hasContent()) {
            List<Tenant> tenants = tenantsList.getContent();
            response = new TableResponseDTO(0, (int) tenantsList.getTotalElements(), (int) tenantsList.getTotalElements(),
                    tenants);
        } else {
            response = new TableResponseDTO(0, (int) tenantsList.getTotalElements(), (int) tenantsList.getTotalElements(),
                    new ArrayList<>());
        }
        return response;
    }
}
