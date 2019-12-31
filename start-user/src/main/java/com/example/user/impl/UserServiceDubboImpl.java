package com.example.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.api.entity.StartUserInfo;
import com.example.api.entity.common.WebConstants;
import com.example.api.entity.exception.BaseException;
import com.example.api.service.dubbo.UserServiceDubbo;
import com.example.api.utils.BeanConvertUtils;
import com.example.api.utils.RedisUtil;
import com.example.user.dao.ext.StartUserExtMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Service
public class UserServiceDubboImpl implements UserServiceDubbo {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private StartUserExtMapper startUserExtMapper;

    @Override
    public StartUserInfo getUserInfo(StartUserInfo user) throws Exception {

        /**
         * 这里存在redis缓存穿透的情况，这个用户的key值不存在，每次请求都直接访问数据库
         *  使用bitmap来存储已有的userId,每次先判断是否再bitmap里，代替布隆过滤器
         */
        boolean isInUser = redisUtil.getBit(WebConstants.IS_IN_USER, Long.parseLong(user.getUserId()));
        if (isInUser) {
            StartUserInfo userInfo = new StartUserInfo();
            Map<Object, Object> userMap = redisUtil.hmget(WebConstants.USER + ":" + user.getUserId());
            if (!userMap.isEmpty()) {
                BeanConvertUtils.mapToObject((Map<String, Object>) BeanConvertUtils.mapToMap(userMap), userInfo);
                return userInfo;
            } else {
                synchronized (user) {
                    Map<Object, Object> userMapTwo = redisUtil.hmget(WebConstants.USER + ":" + user.getUserId());
                    if (!userMapTwo.isEmpty()) {
                        BeanConvertUtils.mapToObject((Map<String, Object>) BeanConvertUtils.mapToMap(userMap), userInfo);
                    } else {
                        userInfo = startUserExtMapper.getUserInfo(Long.parseLong(user.getUserId()));
                    }
                    return userInfo;
                }
            }
        } else {
            throw new BaseException(BaseException.Type.ERROR, "请先前往注册");
        }

    }

}
