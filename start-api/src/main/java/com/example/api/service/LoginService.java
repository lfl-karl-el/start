package com.example.api.service;

import com.example.api.utils.Result;

public interface LoginService {

    Result login(String userName, String password);

    Result phoneLogin(String phoneNumber,String veriCode);

    Result sendVeriCode(String phoneNumber);
}
