package com.techacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.entity.Employee;
import com.techacademy.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class DeleteController {

    @Autowired
    private EmployeeService employeeService;

    /** User削除処理 */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        // IDを使用して従業員情報を取得
        Employee employee = employeeService.findById(id).orElse(null);


        employee.setDeleteFlag(1);


        employeeService.saveEmployee(employee);
        return "redirect:/employee/list";
    }
}
