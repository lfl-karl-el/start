package com.example.controller.controller;

import com.example.api.entity.common.AjaxResult;
import com.example.api.entity.exception.BaseException;
import com.example.controller.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class BaseErrorController{
    private Logger logger = LoggerFactory.getLogger(BaseErrorController.class);


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object error(HttpServletRequest request , Exception e){
        return AjaxResult.error(e.getMessage());
    }

}
