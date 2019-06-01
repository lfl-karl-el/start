package com.example.controller.controller;

import com.example.api.entity.UserBean;
import com.example.api.service.LoginService;
import com.example.api.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: start-LoginController
 * @description: 登录
 * @author: Mr.lfl
 * @create: 2019-01-14 21:48
 **/
@RestController
@RequestMapping("/login")
public class LoginController {

    private Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = {"/toLogin"},method = RequestMethod.POST)
    public Result toLogin(HttpServletRequest request,@RequestBody UserBean userBean){

        String type = userBean.getType();
        if(StringUtils.equals(type,"account")){
            return  loginService.login(userBean.getUserName(),userBean.getPassword());
        }else if(StringUtils.equals("mobile",type)){
            return loginService.phoneLogin(userBean.getMobile(),userBean.getCaptcha());
        }
        return null;
    }


    @RequestMapping(value = {"/captcha"},method = RequestMethod.GET)
    public Result sendVeriCode(HttpServletRequest request){
        return loginService.sendVeriCode(request.getParameter("mobile"));
    }
}
