package com.techacademy.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.entity.Employee;
import com.techacademy.service.EmployeeService;
@Controller
@RequestMapping("/employee")
public class DetailController {
    @Autowired
    private EmployeeService employeeService;


    //** 詳細画面を表示*/
    @GetMapping("/detail/{id}")
    public String showEmployeeDetail(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeService.findById(id).orElse(null);
        model.addAttribute("employee", employee);
        return "detail";
    }

    @GetMapping("/{id}")
    public String getDetail(@PathVariable("id") Integer id, Model model) {
        // 社員情報を取得
        Optional<Employee> employeeOptional = employeeService.findById(id);

        // 社員情報が存在しない場合は一覧画面にリダイレクトする
        if (employeeOptional.isEmpty()) {
            return "redirect:/employee/list";
        }

        // Modelに社員情報を登録
        Employee employee = employeeOptional.get();
        model.addAttribute("employee", employee);

        return "detail";
    }



    // 編集画面で更新ボタンが押されたときの処理


    }

