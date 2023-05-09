package com.calpyte.user.service.impl;

import com.calpyte.user.entity.Adjustment;
import com.calpyte.user.repository.AdjustmentRepository;
import com.calpyte.user.service.AdjustmentService;
import com.calpyte.user.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;

@Service
public class AdjustmentServiceImpl implements AdjustmentService {
    @Autowired
    public AdjustmentRepository adjustmentRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    @Override
    public Adjustment saveAdjustment(Adjustment adjustment) {
        Adjustment adjustmentExist = adjustmentRepository.findByReference(adjustment.getReference());
        if(!ObjectUtils.isEmpty(adjustmentExist)){
            adjustmentExist.setDate(new Date());
            adjustmentRepository.save(adjustmentExist);
            return adjustmentExist;
        }
        else {
            adjustment.setReference("AD"+sequenceGeneratorService.generateSequence("AD").toString());
            adjustment.setDate(new Date());
            adjustmentRepository.save(adjustment);
        }
        return adjustment;
    }


}
