package com.minhan.exam.repository;

import com.minhan.exam.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    UserEntity findByToken(String token);
    void deleteById(int id);
}
