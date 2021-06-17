package com.minhan.exam.service;

import com.minhan.exam.entity.EmployeeEntity;
import com.minhan.exam.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        return employeeRepo.save(employeeEntity);
    }

    @Override
    public List<EmployeeEntity> getEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public EmployeeEntity addEmployee(EmployeeEntity employeeEntity) {
        return employeeRepo.save(employeeEntity);
    }

    @Override
    public EmployeeEntity findById(int id) {
        return employeeRepo.findById(id).get();
    }
}
