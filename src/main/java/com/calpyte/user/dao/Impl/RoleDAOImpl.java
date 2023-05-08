package com.calpyte.user.dao.Impl;

import com.calpyte.user.dao.RoleDAO;

import com.calpyte.user.entity.Role;
import com.calpyte.user.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }


    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(String id) {
        return roleRepository.findById(id);
    }


}
