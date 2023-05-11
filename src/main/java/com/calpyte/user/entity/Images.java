package com.calpyte.user.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Document(collection = "images")
@Entity
@Data
public class Images {
    @Id
    private String id;

    private String name;

    private byte[] file;
}
