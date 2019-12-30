package com.example.controller.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletUtils {
    
    /**
     *  获得HttpServletRequest
     *  date: 2019/12/30 9:50
     * author: lfl
     * @param   
     * @return javax.servlet.http.HttpServletRequest
     */ 
    public static HttpServletRequest getRequest(){
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) attributes;
        return servletRequestAttributes.getRequest();
    }
    
    /**
     *  获得HttpServletResponse
     * date: 2019/12/30 9:52
     * author: lfl
     * @param null  
     * @return 
     */ 
    public static HttpServletResponse getResponse(){
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) attributes;
        return servletRequestAttributes.getResponse();
    }

    /**
     *  获得HttpSession
     * date: 2019/12/30 9:55
     * author: lfl
     * @param
     * @return javax.servlet.http.HttpSession
     */
    public static HttpSession getSession(){
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (HttpSession)attributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
    }
}
