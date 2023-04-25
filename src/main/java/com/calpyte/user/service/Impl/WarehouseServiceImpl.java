package com.calpyte.user.service.Impl;

import com.calpyte.user.Dao.WarehouseDAO;
import com.calpyte.user.domain.Warehouse;
import com.calpyte.user.dto.WarehouseDTO;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.SearchCriteria;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.specification.BaseSpecification;
import com.calpyte.user.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.calpyte.user.service.WarehouseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseDAO warehouseDAO;

    private List<SearchCriteria> params = new ArrayList<>();



    private final MongoTemplate mongoTemplate;

    public WarehouseServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public WarehouseDTO saveWarehouse(WarehouseDTO warehouse)  {
        Warehouse warehouseObj = Mapper.map(warehouse, Warehouse.class);
        warehouseObj.setIsDeleted(false);
        warehouseDAO.save(warehouseObj);
        return warehouse;
    }

//    @Override
//    public List<WarehouseDTO> getAllWarehouses() {
//        List<Warehouse> warehouseList = warehouseDAO.findAll();
//        return warehouseList.stream().map(warehouse -> Mapper.map(warehouse, WarehouseDTO.class)).collect(Collectors.toList());
//    }

    @Override
    public WarehouseDTO findById(String id) {
        Optional<Warehouse> warehouseOptional = warehouseDAO.findById(id);
        if (warehouseOptional.isPresent()) {
            return Mapper.map(warehouseOptional.get(), WarehouseDTO.class);
        }
        return null;
    }


    @Override
    public void delete(String id) {
        Optional<Warehouse> warehouseOpt = warehouseDAO.findById(id);
        if (warehouseOpt.isPresent()) {
            Warehouse warehouse = warehouseOpt.get();
            warehouse.setIsDeleted(true);
            warehouseDAO.save(warehouse);
        }
    }

    @Override
    public TableResponseDTO getWarehouses(PaginationDTO pagination) {
        TableResponseDTO response;
        BaseSpecification warehouseSpecification = new BaseSpecification(mongoTemplate);
        Pageable paging = PageRequest.of(pagination.getPageNo() - 1, pagination.getPageSize());
        params.clear();
        List<SearchCriteria> searchCriteria = pagination.getFilter();
        Page<Warehouse> warehousePage = warehouseSpecification.getAll(searchCriteria,paging,Warehouse.class);
        if (warehousePage.hasContent()) {
            List<Warehouse> warehouseList = warehousePage.getContent();
            response = new TableResponseDTO(0, (int) warehousePage.getTotalElements(), (int) warehousePage.getTotalElements(),
                    warehouseList);
        } else {
            response = new TableResponseDTO(0, (int) warehousePage.getTotalElements(), (int) warehousePage.getTotalElements(),
                    new ArrayList<>());
        }
        return response;
    }
    }

