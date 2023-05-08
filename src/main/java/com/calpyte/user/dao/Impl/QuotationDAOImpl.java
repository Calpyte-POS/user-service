package com.calpyte.user.dao.Impl;

import com.calpyte.user.dao.QuotationDAO;
import com.calpyte.user.entity.Quotation;
import com.calpyte.user.repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class QuotationDAOImpl implements QuotationDAO {

    @Autowired
    private QuotationRepository quotationRepository;

    @Override
    public Optional<Quotation> findByName(String name) {
        return quotationRepository.findByName(name);
    }

    @Override
    public Quotation save(Quotation quotation) {
        return quotationRepository.save(quotation);
    }

    @Override
    public List<Quotation> getAllQuotation() {
        return quotationRepository.findAll();
    }

    @Override
    public Optional<Quotation> findById(String id) {
        return quotationRepository.findById(id);
    }
}
