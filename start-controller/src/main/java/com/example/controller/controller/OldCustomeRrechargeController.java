package com.example.controller.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.api.entity.StartUserInfo;
import com.example.api.entity.common.AjaxResult;
import com.example.api.entity.exception.BaseException;
import com.example.api.service.dubbo.UserServiceDubbo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
* 老用户充值，低于50赠送20元，只有一次机会
* 
* @Author: lfl
* @Date: 2019/12/23 15:37
*/ 

@RestController
@RequestMapping("oldCustome/recharge")
public class OldCustomeRrechargeController {

    private Logger logger = LoggerFactory.getLogger(OldCustomeRrechargeController.class);

    @Reference
    private UserServiceDubbo userServiceDubbo;

    /**
     * 用户一进入直接判断充值，提示
     */
    @RequestMapping("index")
    public AjaxResult index(HttpServletRequest request){
        try {
            String userId = request.getParameter("userId");
            StartUserInfo user = new StartUserInfo();
            user.setUserId(userId);

            user = userServiceDubbo.getUserInfo(user);

            logger.info("-----------------账户"+user.getName()+"余额："+user.getUserFee());

        }catch (Exception e){
            e.printStackTrace();
            throw new BaseException(BaseException.Type.ERROR,e.getMessage());
        }

        return null;
    }
}
