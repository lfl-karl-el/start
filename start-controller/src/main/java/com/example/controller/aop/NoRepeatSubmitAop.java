package com.example.controller.aop;

import com.example.controller.anotation.NoRepeatSubmit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NoRepeatSubmitAop {

    @Around(value = "execution(* com.example.controller.controller..*(..)) && @annotation(nrs)")
    public Object arround(ProceedingJoinPoint point, NoRepeatSubmit nrs){

        return null;
    }
}
