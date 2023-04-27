package com.calpyte.user.entity;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
@Where(clause = "is_deleted = false")
public class User  {


    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
    private String role;

}
