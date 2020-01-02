package com.example.api.service.dubbo;

import com.example.api.entity.StartUserInfo;
import com.example.api.entity.common.AjaxResult;

public interface OrderServiceDubbo {
    /***
     *  老用户充值接口
     * date: 2020/1/2 15:33
     * author: lfl
     * @param   
     * @return com.example.api.entity.common.AjaxResult
     */ 
    AjaxResult oldCustomeRrecharge(StartUserInfo startUserInfo) throws Exception;
}
