package com.example.api.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class StartUserInfo implements Serializable{
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
