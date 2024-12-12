package com.ultratech.passwordgenerator.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {
    private Long id;
    private String username;
    private String password;
    private String email;
}
