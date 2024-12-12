package com.ultratech.passwordgenerator.service.interfaces;

import com.ultratech.passwordgenerator.domain.User;
import com.ultratech.passwordgenerator.domain.model.UserModel;

public interface UserService {
    void register(UserModel model);

    void update(UserModel model);

    User findById(Long id);
}
