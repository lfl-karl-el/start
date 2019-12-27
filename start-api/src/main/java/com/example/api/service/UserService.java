package com.example.api.service;

import com.example.api.entity.StartUserInfo;

public interface UserService {
    
    /**
     *  返回用户的信息
     * date: 2019/12/27 15:15
     * author: lfl
     * @param userId  
     * @return com.example.api.entity.StartUserInfo
     * @throws Exception
     */ 
    StartUserInfo getUserInfo(StartUserInfo user) throws Exception;
}
