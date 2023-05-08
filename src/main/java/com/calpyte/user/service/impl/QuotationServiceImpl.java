package com.calpyte.user.service.impl;

import com.calpyte.user.Specification.BaseSpecification;
import com.calpyte.user.dao.QuotationDAO;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.SearchCriteria;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Quotation;
import com.calpyte.user.entity.Role;
import com.calpyte.user.exceptions.CustomValidationException;
import com.calpyte.user.service.QuotationService;
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
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    private QuotationDAO quotationDAO;

    private List<SearchCriteria> params = new ArrayList<>();

    private final MongoTemplate mongoTemplate;

    public QuotationServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }



    @Override
    public Quotation saveQuotation(Quotation quotation) {
        if (quotation.getName() == null || quotation.getName().trim().isEmpty() || quotationDAO.findByName(quotation.getName()).isPresent()) {
            throw new CustomValidationException("Quotation name is not valid", HttpStatus.BAD_REQUEST);
        }
        return quotationDAO.save(quotation);
    }

    @Override
    public TableResponseDTO getQuotation(PaginationDTO pagination) {
        TableResponseDTO response;
        BaseSpecification quotationSpecification = new BaseSpecification(mongoTemplate);
        Pageable paging = PageRequest.of(pagination.getPageNo() - 1, pagination.getPageSize());
        params.clear();
        List<SearchCriteria> searchCriteria = pagination.getFilter();
        Page<Quotation> quotationPage = quotationSpecification.getAll(searchCriteria,paging,Quotation.class);
        if (quotationPage.hasContent()) {
            List<Quotation> roleList = quotationPage.getContent();
            response = new TableResponseDTO(0, (int) quotationPage.getTotalElements(), (int) quotationPage.getTotalElements(),
                    roleList);
        } else {
            response = new TableResponseDTO(0, (int) quotationPage.getTotalElements(), (int) quotationPage.getTotalElements(),
                    new ArrayList<>());
        }
        return response;
    }

    @Override
    public List<Quotation> getAllQuotation() {
        return quotationDAO.getAllQuotation();
    }

    @Override
    public Quotation findById(String id) {
        Optional<Quotation> quotationOptional = quotationDAO.findById(id);
        if (quotationOptional.isPresent()) {
            return Mapper.map(quotationOptional.get(), Quotation.class);
        }
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
