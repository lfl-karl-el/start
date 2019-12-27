package com.example.user.dao.ext;

import com.example.api.entity.StartUserInfo;
import com.example.user.entity.StartUserFeeInfo;

import java.util.List;

public interface StartUserExtMapper {
    StartUserInfo getUserInfo(Long userId);
}