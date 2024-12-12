package com.ultratech.passwordgenerator.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordModel {
    private Long id;
    private Long userId;
    public String serviceName;
    private String password;
}
