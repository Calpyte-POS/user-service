package com.calpyte.user.controller;

import com.calpyte.user.dto.Pagination;
import com.calpyte.user.entity.Tenant;
import com.calpyte.user.service.TenantService;
import com.calpyte.user.utils.TableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @PostMapping("/")
    public ResponseEntity<Tenant> saveTenant(@RequestBody Tenant tenant){
        return ResponseEntity.ok(tenantService.saveTenant(tenant));
    }

    @PostMapping("/paging")
    public ResponseEntity<TableResponse> getAll(@RequestBody Pagination pagination){
        return ResponseEntity.ok(tenantService.getAll(pagination));
    }
}
