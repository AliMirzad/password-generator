package com.ultratech.passwordgenerator.dao;

import com.ultratech.passwordgenerator.domain.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordDao extends JpaRepository<Password, Long> {
    Password findPasswordByServiceName(String serviceName);
}
