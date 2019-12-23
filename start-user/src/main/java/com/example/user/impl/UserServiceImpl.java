package com.example.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.api.entity.StartUserInfo;
import com.example.api.service.UserService;

@Service(version = "userServiceImpl")
public class UserServiceImpl implements UserService{


    @Override
    public StartUserInfo getUserInfo(int userId) {
        return null;
    }
}
