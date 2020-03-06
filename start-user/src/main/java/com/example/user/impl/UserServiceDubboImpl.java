package com.example.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.api.entity.StartUserInfo;
import com.example.api.entity.common.WebConstants;
import com.example.api.entity.exception.BaseException;
import com.example.api.service.dubbo.UserServiceDubbo;
import com.example.api.utils.BeanConvertUtils;
import com.example.api.utils.RedisUtil;
import com.example.user.dao.ext.StartUserExtMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service(timeout = 15000)
public class UserServiceDubboImpl implements UserServiceDubbo {
    private Logger log = LoggerFactory.getLogger(UserServiceDubboImpl.class);

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private StartUserExtMapper startUserExtMapper;

    @Override
    public StartUserInfo getUserInfo(String userId) throws Exception {

        /**
         * 这里存在redis缓存穿透的情况，这个用户的key值不存在，每次请求都直接访问数据库
         *  使用bitmap来存储已有的userId,每次先判断是否再bitmap里，代替布隆过滤器
         */
        boolean isInUser = redisUtil.getBit(WebConstants.IS_IN_USER, Long.parseLong(userId));
        if (isInUser) {
            Map<Object, Object> userMap = redisUtil.hmget(WebConstants.USER + ":" + userId);
            StartUserInfo userInfo = new StartUserInfo();
            userInfo.setUserId(userId);
            if (!userMap.isEmpty()) {
                BeanConvertUtils.mapToObject((Map<String, Object>) BeanConvertUtils.mapToMap(userMap), userInfo);
                return userInfo;
            } else {
                userInfo = startUserExtMapper.getUserInfo(Long.parseLong(userId));
                Map<String,Object> userMapObj = new HashMap<>();
                userMapObj.put("userId", userInfo.getUserId());
                userMapObj.put("name", userInfo.getName());
                userMapObj.put("userFee", userInfo.getUserFee());
                redisUtil.hmset(WebConstants.USER + ":" + userId,userMapObj);
                return userInfo;
            }
        } else {
            throw new BaseException(BaseException.Type.ERROR, "请先前往注册");
        }

    }

}
