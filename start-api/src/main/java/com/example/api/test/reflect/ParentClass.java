package com.example.api.test.reflect;

import lombok.Data;

@Data
public class ParentClass {
    public String name;
    protected String age;
    private int money;

    public String getAll(){
        System.out.println("得到全部");
        return "全部";
    }

    public class innerClass{
        private int  innerName;
    }
}
