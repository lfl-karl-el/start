package com.example.api.test.reflect;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class SonClass extends ParentClass{
    private String total;

    public String getSingle(){
        return "home";
    }
}
