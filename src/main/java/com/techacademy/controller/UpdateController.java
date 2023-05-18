package com.techacademy.controller;



import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.entity.Employee;
import com.techacademy.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class UpdateController {
    @Autowired
    private EmployeeService employeeService;


    //** 従業員の更新画面の表示*/
    @GetMapping("/update/{id}")
    public String getUser(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeService.findById(id).orElse(null);
        // Modelに登録
        model.addAttribute("employee", employee);
        // User更新画面に遷移
        return "update";
    }

    //** 従業員情報の更新処理*/
    @PostMapping("/update/{id}")
    public String postUser(@ModelAttribute Employee updateEmployee, @PathVariable("id") Integer id ) {

        // IDを使用して従業員情報を取得
        Employee employee = employeeService.findById(id).orElse(null);

        /*不足しているフィールドに値をセットする */
        employee.setName(updateEmployee.getName());
        employee.getAuthentication().setPassword(updateEmployee.getPassword());
        employee.getAuthentication().setRole(updateEmployee.getRole());


        employee.setDeleteFlag(0);

        //登録日時をセットする
        Timestamp now = new Timestamp(System.currentTimeMillis());
        employee.setCreatedAt(now);

        //更新日時のセット
        employee.setUpdatedAt(now);


        employeeService.updateEmployee(employee);
        return "redirect: /employee/list";
    }
}




