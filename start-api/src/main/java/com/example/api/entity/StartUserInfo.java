package com.example.api.entity;

import lombok.Data;

@Data
public class StartUserInfo {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户金额
     */
    private String userFee;
}
