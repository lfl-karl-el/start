package com.example.order.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.example.api.entity.StartUserInfo;
import com.example.api.entity.common.AjaxResult;
import com.example.api.service.dubbo.OrderServiceDubbo;
import com.example.api.service.dubbo.UserServiceDubbo;

import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class OrderServiceDubboImpl implements OrderServiceDubbo {

    @Reference
    private UserServiceDubbo userServiceDubbo;

    @Override
    public AjaxResult oldCustomeRrecharge(StartUserInfo startUserInfo) throws Exception {
        AjaxResult ajaxResult = new AjaxResult();

        return null;
    }
}
