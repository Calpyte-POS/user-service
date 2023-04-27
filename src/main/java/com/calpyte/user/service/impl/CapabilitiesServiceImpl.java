package com.calpyte.user.service.impl;

import com.calpyte.user.dao.CapabilitiesDAO;

import com.calpyte.user.entity.Capabilities;
import com.calpyte.user.exceptions.CustomValidationException;
import com.calpyte.user.service.CapabilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapabilitiesServiceImpl implements CapabilitiesService {

    @Autowired
    private CapabilitiesDAO capabilitiesDAO;


    @Override
    public Capabilities saveCapabilities(Capabilities capabilities) {
        if (capabilities.getName() == null || capabilities.getName().trim().isEmpty() || capabilitiesDAO.findByName(capabilities.getName()).isPresent()) {
            throw new CustomValidationException("Capabilities name is not valid", HttpStatus.BAD_REQUEST);
        }
        return capabilitiesDAO.save(capabilities);
    }

    @Override
    public List<Capabilities> getAllCapabilities() {
        return capabilitiesDAO.getAllCapabilities();
    }
}
