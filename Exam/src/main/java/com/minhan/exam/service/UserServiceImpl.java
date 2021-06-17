package com.minhan.exam.service;

import com.minhan.exam.entity.UserEntity;
import com.minhan.exam.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Override
    public UserEntity login(String username, String password) {
        UserEntity user = userRepo.findByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (encoder.matches(password, user.getPassword())) {
            String token = UUID.randomUUID().toString() + "-" +System.currentTimeMillis();
            user.setToken(token);
            UserEntity userNew = userRepo.save(user);
            return userNew;
        }
        return null;
    }

    @Override
    public UserEntity findUserByToken(String token) {
        return userRepo.findByToken(token);
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void deleteUser(int id) {
       userRepo.deleteById(id);
    }
}
