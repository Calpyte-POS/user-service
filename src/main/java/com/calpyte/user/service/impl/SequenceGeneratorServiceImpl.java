package com.calpyte.user.service.impl;


import com.calpyte.user.entity.SequenceGenerator;
import com.calpyte.user.repository.SequenceGeneratorRepository;
import com.calpyte.user.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SequenceGeneratorServiceImpl implements SequenceGeneratorService {
    @Autowired
    private SequenceGeneratorRepository sequenceGeneratorRepository;

    public Long generateSequence(String sequenceName) {
        SequenceGenerator sequenceGenerator = sequenceGeneratorRepository.findByid(sequenceName);

        if(sequenceGenerator == null) {
            sequenceGenerator = new SequenceGenerator(sequenceName, 1L);
        } else {
            sequenceGenerator.setSequenceValue(sequenceGenerator.getSequenceValue() + 1L);
        }

        sequenceGenerator = sequenceGeneratorRepository.save(sequenceGenerator);
        return sequenceGenerator.getSequenceValue();
    }
}
