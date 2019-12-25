package com.example.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.api.entity.StartUserInfo;
import com.example.api.entity.common.WebConstants;
import com.example.api.service.UserService;
import com.example.api.utils.BeanConvertUtils;
import com.example.api.utils.RedisUtil;
import com.example.user.dao.ext.StartUserExtMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Service(version = "userServiceImpl")
public class UserServiceImpl implements UserService{

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private StartUserExtMapper startUserExtMapper;

    @Override
    public StartUserInfo getUserInfo(int userId) {
        try {

            /**
             * 这里存在redis缓存穿透的情况，这个用户的key值不存在，每次请求都直接访问数据库
             *  使用bitmap来存储已有的userId,每次先判断是否再bitmap里，代替布隆过滤器
             */
            boolean isInUser = redisUtil.getBit(WebConstants.IS_IN_USER,userId);
            if(isInUser){
                Map<Object,Object> userMap= redisUtil.hmget(WebConstants.USER+":"+userId);
                if(null != userMap){
                    StartUserInfo userInfo = new StartUserInfo();
//                    BeanConvertUtils.mapToObject(userMap,userInfo);
                    return userInfo;
                }
            }else{

            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
