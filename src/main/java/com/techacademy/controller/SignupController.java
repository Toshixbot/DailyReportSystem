package com.techacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.techacademy.entity.Employee;
import com.techacademy.service.EmployeeService;

@Controller
public class SignupController {
    @Autowired
    private EmployeeService employeeService;


    //** 従業員の新規登録画面表示*/
    @GetMapping("employee/signup")
    public String newEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "signup";
    }
    //** 従業員の新規登録処理*/
    @PostMapping("employee/signup")
    public String createEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee/list";
    }

}
