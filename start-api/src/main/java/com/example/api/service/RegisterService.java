package com.example.api.service;

import com.example.api.entity.UserBean;
import com.example.api.utils.Result;

public interface RegisterService {
    Result register(UserBean userBean);
}
