package com.ultratech.passwordgenerator.service.interfaces;

import com.ultratech.passwordgenerator.domain.model.PasswordModel;

import java.util.List;

public interface PasswordService {
    void save(PasswordModel model);

    void update(PasswordModel model);

    void delete(long id);

    PasswordModel findByServiceName(String serviceName);

    List<PasswordModel> findAll();
}
