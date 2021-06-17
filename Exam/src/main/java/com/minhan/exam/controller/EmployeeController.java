package com.minhan.exam.controller;

import com.minhan.exam.dto.EmployeeDto;
import com.minhan.exam.entity.EmployeeEntity;
import com.minhan.exam.model.BaseResponse;
import com.minhan.exam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/api/public/getEmployee")
    public BaseResponse getEmployee(){

        BaseResponse res = new BaseResponse();

        List<EmployeeEntity> list = employeeService.getEmployee();
        res.status = 1 ;
        res.message = "Thanh coong";
        res.data = list;

        return res;
    }

    @PostMapping("/api/public/addEmployee")
    public BaseResponse addEmployee(@RequestBody EmployeeDto employeeDto){
        BaseResponse res = new BaseResponse();

        if (employeeDto != null){
            EmployeeEntity e = new EmployeeEntity();
            e.setName(employeeDto.getName());
            e.setSalary(employeeDto.getSalary());
            EmployeeEntity enew = employeeService.addEmployee(e);
            if(enew != null){
                res.status = 1;
                res.message = "Thanh cong";
                res.data =enew;
            }
        }
        return res;
    }
    @PostMapping("/api/public/updateEmployee")
    public BaseResponse updateEmployee(@RequestBody EmployeeDto employeeDto){
        BaseResponse res = new BaseResponse();
        if(employeeDto.getId() > 0){
            EmployeeEntity emp = employeeService.findById(employeeDto.getId());
            if(emp != null){
                EmployeeEntity empU = new EmployeeEntity();
                empU.setId(employeeDto.getId());
                empU.setName(employeeDto.getName());
                empU.setSalary(employeeDto.getSalary());

                res.status = 1;
                res.message = "Thanh cong";
                res.data = employeeService.updateEmployee(empU);
            }else {
                res.message = "Id not found";
            }
        }
        return res;
    }
}
