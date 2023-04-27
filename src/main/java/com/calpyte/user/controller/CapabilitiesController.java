package com.calpyte.user.controller;


import com.calpyte.user.entity.Capabilities;
import com.calpyte.user.service.CapabilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/capabilities")
public class CapabilitiesController {

    @Autowired
    private CapabilitiesService capabilitiesService;


    @PostMapping("/")
    public ResponseEntity<Capabilities> saveCapabilities(@RequestBody Capabilities capabilities) {
        return ResponseEntity.ok(capabilitiesService.saveCapabilities(capabilities));
    }


    @GetMapping("")
    public ResponseEntity<List<Capabilities>> getAllCapabilities() {
        return ResponseEntity.ok(capabilitiesService.getAllCapabilities());
    }

}
