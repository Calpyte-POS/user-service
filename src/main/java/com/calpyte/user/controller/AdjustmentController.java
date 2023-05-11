package com.calpyte.user.controller;

import com.calpyte.user.entity.Adjustment;
import com.calpyte.user.service.AdjustmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adjustment")
public class AdjustmentController {
    @Autowired
    private AdjustmentService adjustmentService;

    @PostMapping("")
    public ResponseEntity<Adjustment> saveAdjustment(@RequestBody Adjustment adjustment){
        return ResponseEntity.ok(adjustmentService.saveAdjustment(adjustment));
    }
}
