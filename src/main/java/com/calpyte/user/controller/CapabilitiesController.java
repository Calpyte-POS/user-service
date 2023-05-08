package com.calpyte.user.controller;


import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Capabilities;
import com.calpyte.user.entity.Role;
import com.calpyte.user.service.CapabilitiesService;
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
@RequestMapping("/capabilities")
public class CapabilitiesController {

    @Autowired
    private CapabilitiesService capabilitiesService;


    @PostMapping("/save")
    public ResponseEntity<Capabilities> saveCapabilities(@RequestBody Capabilities capabilities) {
        return ResponseEntity.ok(capabilitiesService.saveCapabilities(capabilities));
    }


    @GetMapping("")
    public ResponseEntity<List<Capabilities>> getAllCapabilities() {
        return ResponseEntity.ok(capabilitiesService.getAllCapabilities());
    }

    @PostMapping(value = "")
    public ResponseEntity<TableResponseDTO> getCapabilities(@RequestBody PaginationDTO pagination){
        return new ResponseEntity<>(capabilitiesService.getRoles(pagination), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<Capabilities> findById(@RequestParam("id") String id) {
        return new ResponseEntity<>(capabilitiesService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<Capabilities> delete(@RequestParam("id") String id){
        capabilitiesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
