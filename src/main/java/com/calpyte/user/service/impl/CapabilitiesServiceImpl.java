package com.calpyte.user.service.impl;

import com.calpyte.user.Specification.BaseSpecification;
import com.calpyte.user.dao.CapabilitiesDAO;

import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.SearchCriteria;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Capabilities;

import com.calpyte.user.entity.Role;
import com.calpyte.user.exceptions.CustomValidationException;
import com.calpyte.user.service.CapabilitiesService;
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
public class CapabilitiesServiceImpl implements CapabilitiesService {

    @Autowired
    private CapabilitiesDAO capabilitiesDAO;


    private List<SearchCriteria> params = new ArrayList<>();

    private final MongoTemplate mongoTemplate;


    public CapabilitiesServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


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

    @Override
    public TableResponseDTO getRoles(PaginationDTO pagination) {
        TableResponseDTO response;
        BaseSpecification capabilitiesSpecification = new BaseSpecification(mongoTemplate);
        Pageable paging = PageRequest.of(pagination.getPageNo() - 1, pagination.getPageSize());
        params.clear();
        List<SearchCriteria> searchCriteria = pagination.getFilter();
        Page<Capabilities> capabilitiesPage = capabilitiesSpecification.getAll(searchCriteria,paging,Capabilities.class);
        if (capabilitiesPage.hasContent()) {
            List<Capabilities> capabilitiesList = capabilitiesPage.getContent();
            response = new TableResponseDTO(0, (int) capabilitiesPage.getTotalElements(), (int) capabilitiesPage.getTotalElements(),
                    capabilitiesList);
        } else {
            response = new TableResponseDTO(0, (int) capabilitiesPage.getTotalElements(), (int) capabilitiesPage.getTotalElements(),
                    new ArrayList<>());
        }
        return response;
    }

    @Override
    public Capabilities findById(String id) {
        Optional<Capabilities> capabilitiesOptional = capabilitiesDAO.findById(id);
        if (capabilitiesOptional.isPresent()) {
            return Mapper.map(capabilitiesOptional.get(), Capabilities.class);
        }
        return null;
    }

    @Override
    public void delete(String id) {
        Optional<Capabilities> capabilitiesOptional = capabilitiesDAO.findById(id);
        if (capabilitiesOptional.isPresent()) {
            Capabilities capabilities = capabilitiesOptional.get();
            capabilitiesDAO.save(capabilities);
        }
    }
}
