package com.example.controller.controller;

import com.example.api.entity.UserBean;
import com.example.api.service.RegisterService;
import com.example.api.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value= { "/register" }, method = RequestMethod.POST)
    public Result doRegister(HttpServletRequest req,@RequestBody UserBean userBean){
        Result result =  registerService.register(userBean);
        return result;
    }
}
