package com.calpyte.user.controller;

import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Tenant;
import com.calpyte.user.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<TableResponseDTO> getAll(@RequestBody PaginationDTO pagination){
        return ResponseEntity.ok(tenantService.getAll(pagination));
    }
}
