package com.minhan.exam.service;

import com.minhan.exam.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
    List<EmployeeEntity> getEmployee();
    EmployeeEntity addEmployee(EmployeeEntity employeeEntity);
    EmployeeEntity findById(int id);
}
