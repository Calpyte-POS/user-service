package com.calpyte.user.service;

import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Quotation;

import java.util.List;

public interface QuotationService {
    Quotation saveQuotation(Quotation quotation);

    TableResponseDTO getQuotation(PaginationDTO pagination);

    List<Quotation> getAllQuotation();


    Quotation findById(String id);

    void delete(String id);
}
