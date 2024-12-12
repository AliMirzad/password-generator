package com.ultratech.passwordgenerator.service;

import com.ultratech.passwordgenerator.dao.UserDao;
import com.ultratech.passwordgenerator.domain.User;
import com.ultratech.passwordgenerator.domain.model.UserModel;
import com.ultratech.passwordgenerator.exception.UserException;
import com.ultratech.passwordgenerator.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private PasswordEncoder passwordEncoder;

    @Override
    public void register(UserModel model) {
        User user = new User();
        user.setUsername(model.getUsername());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        user.setEmail(model.getEmail());
        userDao.save(user);
    }

    @Override
    public void update(UserModel model) {
        User user = userDao.findById(model.getId())
                .orElseThrow(() ->new UserException(UserException.userNotFound));
        user.setUsername(model.getUsername());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        user.setEmail(model.getEmail());
        userDao.save(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id)
                .orElseThrow(() -> new UserException(UserException.userNotFound));
    }
}
