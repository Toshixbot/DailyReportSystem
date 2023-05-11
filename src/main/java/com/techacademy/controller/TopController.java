package com.techacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller

public class TopController {






    /**トップページを表示*/
    @GetMapping("/top")
    public String getList() {

        return "top";
    }
}