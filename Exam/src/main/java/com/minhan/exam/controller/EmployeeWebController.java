package com.minhan.exam.controller;

import com.minhan.exam.entity.EmployeeEntity;
import com.minhan.exam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeWebController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public String employee(Model model){
//        List<EmployeeEntity> list = employeeService.getEmployee();
//        model.addAttribute("list", list);
        return "employee";
    }
}
