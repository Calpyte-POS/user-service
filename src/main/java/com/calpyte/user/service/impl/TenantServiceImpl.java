package com.calpyte.user.service.impl;

import com.calpyte.user.dto.Pagination;
import com.calpyte.user.entity.Tenant;
import com.calpyte.user.repository.TenantRepository;
import com.calpyte.user.service.TenantService;
import com.calpyte.user.utils.TableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    private TenantRepository tenantRepository;

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
    public TableResponse getAll(Pagination pagination) {
//        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize(), Sort.by(pagination.getSort()));
//        return tenantRepository.findByBusinessName(pagination.getSort(),pageable);
        TableResponse response;
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize());
        Page<Tenant> tenants = tenantRepository.findAll(pageable);
        if(tenants.hasContent()){
            List<Tenant> tenantList = tenants.getContent();
//            List<Tenant> tenantList = tenantRepository.findAllWithLimit(tenants.getSize());
            response = new TableResponse(0, (int) tenants.getTotalElements(), (int) tenants.getTotalElements(),
                    tenantList);
        }
        else {
            response = new TableResponse(0, (int) tenants.getTotalElements(), (int) tenants.getTotalElements(),
                    new ArrayList<>());
        }
        return response;
    }
}
