package com.minhan.exam.repository;

import com.minhan.exam.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity , Integer> {
}
