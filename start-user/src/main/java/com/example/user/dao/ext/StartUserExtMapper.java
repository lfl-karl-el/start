package com.example.user.dao.ext;

import com.example.api.entity.StartUserInfo;
import com.example.user.entity.StartUserFeeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StartUserExtMapper {
    StartUserInfo getUserInfo(Long userId);
}