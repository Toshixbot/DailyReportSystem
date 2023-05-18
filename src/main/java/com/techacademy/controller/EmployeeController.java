package com.techacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.entity.Employee;
import com.techacademy.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //** 一覧画面を表示*/
    @GetMapping("/list")
    public String showEmployeeList(Model model) {
        List<Employee> employeeList = employeeService.getEmployeeList();
        int totalCount = employeeService.getEmployeeCount();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("totalCount", totalCount);
        return "list";
    }

    //全件レコード表示

    }










