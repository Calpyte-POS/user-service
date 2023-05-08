package com.calpyte.user.service.impl;


import com.calpyte.user.Specification.BaseSpecification;
import com.calpyte.user.dao.RoleDAO;

import com.calpyte.user.dto.WarehouseDTO;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.SearchCriteria;
import com.calpyte.user.dto.pagination.TableResponseDTO;

import com.calpyte.user.entity.Role;
import com.calpyte.user.entity.Warehouse;
import com.calpyte.user.exceptions.CustomValidationException;
import com.calpyte.user.service.RoleService;
import com.calpyte.user.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    private List<SearchCriteria> params = new ArrayList<>();

    private final MongoTemplate mongoTemplate;


    public RoleServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Role saveRole(Role role) {
        if (role.getName() == null || role.getName().trim().isEmpty() || roleDAO.findByName(role.getName()).isPresent()) {
            throw new CustomValidationException("Role name is not valid", HttpStatus.BAD_REQUEST);
        }
        return roleDAO.save(role);
    }



    @Override
    public TableResponseDTO getRoles(PaginationDTO pagination) {
        TableResponseDTO response;
        BaseSpecification roleSpecification = new BaseSpecification(mongoTemplate);
        Pageable paging = PageRequest.of(pagination.getPageNo() - 1, pagination.getPageSize());
        params.clear();
        List<SearchCriteria> searchCriteria = pagination.getFilter();
        Page<Role> rolePage = roleSpecification.getAll(searchCriteria,paging,Role.class);
        if (rolePage.hasContent()) {
            List<Role> roleList = rolePage.getContent();
            response = new TableResponseDTO(0, (int) rolePage.getTotalElements(), (int) rolePage.getTotalElements(),
                    roleList);
        } else {
            response = new TableResponseDTO(0, (int) rolePage.getTotalElements(), (int) rolePage.getTotalElements(),
                    new ArrayList<>());
        }
        return response;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public Role findById(String id) {
        Optional<Role> roleOptional = roleDAO.findById(id);
        if (roleOptional.isPresent()) {
            return Mapper.map(roleOptional.get(), Role.class);
        }
        return null;
    }

    @Override
    public void delete(String id) {
        Optional<Role> roleOptional = roleDAO.findById(id);
        if (roleOptional.isPresent()) {
            Role role = roleOptional.get();
            roleDAO.save(role);
        }
    }
}





