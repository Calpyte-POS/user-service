package com.calpyte.user.entity;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;


@Data
public class User  {


    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private String confirmPassword;
    private String role;

    private String userName;
    private String password;
}
