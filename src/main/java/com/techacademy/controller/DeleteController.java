package com.techacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class DeleteController {

    @Autowired
    private EmployeeService employeeService;

    /** User削除処理 */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee/list";
    }
}
