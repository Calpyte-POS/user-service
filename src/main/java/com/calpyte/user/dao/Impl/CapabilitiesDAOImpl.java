package com.calpyte.user.dao.Impl;

import com.calpyte.user.dao.CapabilitiesDAO;

import com.calpyte.user.entity.Capabilities;
import com.calpyte.user.repository.CapabilitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CapabilitiesDAOImpl implements CapabilitiesDAO {

    @Autowired
    private CapabilitiesRepository capabilitiesRepository;


    @Override
    public Optional<Capabilities> findByName(String name) {
        return capabilitiesRepository.findByName(name);
    }

    @Override
    public Capabilities save(Capabilities capabilities) {
        return capabilitiesRepository.save(capabilities);
    }

    @Override
    public List<Capabilities> getAllCapabilities() {
        return capabilitiesRepository.findAll();
    }



    @Override
    public Optional<Capabilities> findById(String id) {
        return capabilitiesRepository.findById(id);
    }
}
