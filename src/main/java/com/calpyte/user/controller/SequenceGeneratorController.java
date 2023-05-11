package com.calpyte.user.controller;

import com.calpyte.user.entity.SequenceGenerator;
import com.calpyte.user.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customSequences")
public class SequenceGeneratorController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    @PostMapping("")
    public void generateSequence(SequenceGenerator primarySequence) {
        primarySequence.setSequenceValue(sequenceGeneratorService.generateSequence(primarySequence.getId()));
        mongoTemplate.save(primarySequence);
    }
}
