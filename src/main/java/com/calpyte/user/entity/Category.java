package com.calpyte.user.entity;

import com.calpyte.user.dto.BasicDTO;
import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "category")
public class Category {
    @Id
    private String id;
    private String name;

    private Binary image;
}
