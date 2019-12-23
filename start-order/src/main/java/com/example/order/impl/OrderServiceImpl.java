package com.example.order.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.api.service.OrderService;

@Service(version = "orderServiceImpl")
public class OrderServiceImpl implements OrderService{
}
