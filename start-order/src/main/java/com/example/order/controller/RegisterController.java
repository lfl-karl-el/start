package com.example.order.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RegisterController {

    @RequestMapping("/test")
    public String test(){
        return "aaaa";
    }
}
