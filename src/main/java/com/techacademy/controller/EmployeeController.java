package com.techacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




import com.techacademy.entity.Employee;
import com.techacademy.service.EmployeeService;

@Controller

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //** 一覧画面を表示*/
    @GetMapping("employee/list")
    public String showEmployeeList(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        return "list";
    }



    // 編集画面で更新ボタンが押されたときの処理





    }





