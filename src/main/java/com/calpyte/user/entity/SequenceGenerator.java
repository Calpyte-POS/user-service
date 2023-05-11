package com.calpyte.user.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "customSequences")
public class SequenceGenerator {
    @Id
    private String id;

    private Long sequenceValue;

    public SequenceGenerator() {}

    public SequenceGenerator(String id, Long sequenceValue) {
        this.id = id;
        this.sequenceValue = sequenceValue;
    }

}
