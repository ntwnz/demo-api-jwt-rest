package com.ntwnz.jwt.api.service;

import com.ntwnz.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ntwnz.jwt.api.model.User;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    public void createUser(User user){
        String pswd = user.getPassword();
        user.setPassword(encoder.encode(pswd));
        repository.save(user);
    }
}
