package com.minhan.exam.service;

import com.minhan.exam.entity.UserEntity;

public interface UserService {
    UserEntity login(String username, String password);
    UserEntity findUserByToken(String token);
    UserEntity findUserByUsername(String username);
    void deleteUser(int id);
}
