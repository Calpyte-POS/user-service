package com.calpyte.user.dao;

import com.calpyte.user.entity.Quotation;

import java.util.List;
import java.util.Optional;

public interface QuotationDAO {
    Optional<Quotation> findByName(String name);

    Quotation save(Quotation quotation);

    List<Quotation> getAllQuotation();

    Optional<Quotation> findById(String id);
}
