package com.calpyte.user.controller;


import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Quotation;
import com.calpyte.user.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quotation")
public class QuotationController {

    @Autowired
    private QuotationService quotationService;

    @PostMapping("/save")
    public ResponseEntity<Quotation> saveQuotation(@RequestBody Quotation quotation){
        return ResponseEntity.ok(quotationService.saveQuotation(quotation));
    }

    @PostMapping(value = "/")
    public ResponseEntity<TableResponseDTO> getQuotation(@RequestBody PaginationDTO pagination){
        return new ResponseEntity<>(quotationService.getQuotation(pagination), HttpStatus.ACCEPTED);
    }

    @GetMapping("")
    public ResponseEntity<List<Quotation>> getAllQuotation(){
        return ResponseEntity.ok(quotationService.getAllQuotation());
    }

    @GetMapping("/by-id")
    public ResponseEntity<Quotation> findById(@RequestParam("id") String id){
        return new ResponseEntity<>(quotationService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<Quotation> delete(@RequestParam("id") String id){
        quotationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

