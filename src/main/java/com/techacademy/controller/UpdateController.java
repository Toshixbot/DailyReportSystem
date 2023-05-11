package com.techacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.techacademy.entity.Employee;
import com.techacademy.service.EmployeeService;

@Controller
public class UpdateController {
    @Autowired
    private EmployeeService employeeService;


    //** 従業員の更新画面の表示*/
    @GetMapping("employee/update/{id}/")
    public String getUser(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeService.findById(id).orElse(null);
        // Modelに登録
        model.addAttribute("employee", employee);
        // User更新画面に遷移
        return "update";
    }

    //** 従業員情報の更新処理*/
    @PostMapping("employee/update")
    public String updateUser(@ModelAttribute Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/employee/list";
    }

}
