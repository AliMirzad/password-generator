package com.ultratech.passwordgenerator.service;

import com.ultratech.passwordgenerator.dao.PasswordDao;
import com.ultratech.passwordgenerator.domain.Password;
import com.ultratech.passwordgenerator.domain.User;
import com.ultratech.passwordgenerator.domain.model.PasswordModel;
import com.ultratech.passwordgenerator.exception.PasswordException;
import com.ultratech.passwordgenerator.service.interfaces.PasswordService;
import com.ultratech.passwordgenerator.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class PasswordServiceImpl implements PasswordService {

    private PasswordDao passwordDao;

    private UserService userService;

    @Override
    public void save(PasswordModel model) {
        passwordDao.save(mapToEntity(model));
    }

    @Override
    public void update(PasswordModel model) {
        Password password = passwordDao.findById(model.getId())
                .orElseThrow(() -> new PasswordException(PasswordException.passwordNotFound));
        password.setServiceName(model.getServiceName());
        password.setPassword(model.getPassword());
        passwordDao.save(password);
    }

    @Override
    public void delete(long id) {
        passwordDao.deleteById(id);
    }

    @Override
    public PasswordModel findByServiceName(String serviceName) {
        return mapToModel(
                passwordDao.findPasswordByServiceName(serviceName)
        );
    }

    @Override
    public List<PasswordModel> findAll() {
        return passwordDao.findAll().stream()
                .map(this::mapToModel).collect(Collectors.toList());
    }

    private PasswordModel mapToModel(Password password) {
        PasswordModel model = new PasswordModel();
        model.setUserId(password.getUser().getId());
        model.setPassword(password.getPassword());
        model.setServiceName(password.getServiceName());
        return model;
    }

    private Password mapToEntity(PasswordModel model) {
        Password password = new Password();
        User user = userService.findById(model.getUserId());
        password.setUser(user);
        password.setServiceName(model.getServiceName());
        password.setPassword(model.getPassword());
        return password;
    }
}
