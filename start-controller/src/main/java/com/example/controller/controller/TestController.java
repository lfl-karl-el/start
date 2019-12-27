package com.example.controller.controller;

import com.example.controller.anotation.NoRepeatSubmit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @NoRepeatSubmit
    @RequestMapping("test")
    public String test(){

        return "enen";
    }
}
