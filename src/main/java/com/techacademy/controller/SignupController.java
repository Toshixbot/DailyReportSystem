package com.techacademy.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.entity.Employee;
import com.techacademy.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class SignupController {
    @Autowired
    private EmployeeService employeeService;


    //** 従業員の新規登録画面表示*/
    @GetMapping("/signup")
    public String newEmployee(@ModelAttribute Employee employee) {
        // User登録画面に遷移
        return "signup";
    }
    //** 従業員の新規登録処理*/
    @PostMapping("/signup")
    public String createEmployee(@ModelAttribute Employee employee) {

        //不足しているフィールドに値をセットする
        employee.setName(employee.getName());
        employee.getAuthentication().setCode(employee.getCode());
        employee.getAuthentication().setPassword(employee.getPassword());
        employee.getAuthentication().setRole(employee.getAuthentication().getRole());


        employee.setDeleteFlag(0);
        employee.getAuthentication().setEmployee(employee);
        //登録日時をセットする
        Timestamp now = new Timestamp(System.currentTimeMillis());
        employee.setCreatedAt(now);

        //更新日時のセット
        employee.setUpdatedAt(now);



        employeeService.saveEmployee(employee);
        return "redirect:/employee/list";
    }

}
