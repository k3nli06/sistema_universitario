package com.uni.sistemaUniversitario.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Controller {

    @GetMapping("hello-world")
    public String getMethodName() {
        return "Hello World";
    }
    

}
