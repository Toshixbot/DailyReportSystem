package com.techacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class TopController {






    /**トップページを表示*/
    @GetMapping("/")
    public String getList() {

        return "top";
    }
}