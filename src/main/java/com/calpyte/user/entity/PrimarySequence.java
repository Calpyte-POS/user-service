package com.calpyte.user.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class PrimarySequence {
    @Id
    private String id;
    private String name;
    private String sequenceId;
}
