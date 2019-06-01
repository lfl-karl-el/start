package com.example.user.serviceImpl;

import com.example.api.entity.UserBean;
import com.example.api.service.RegisterService;
import com.example.api.utils.Result;
import com.example.user.dao.TUserMapper;
import com.example.user.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public Result register(UserBean userBean) {
        TUser tUser = new TUser();
        tUser.setUserName(userBean.getUserName());
        List<TUser> tUserList = tUserMapper.selectAllUser(tUser);
        if(tUserList.size() > 0){
            return new Result(false,"名称重复");
        }
        tUser.setPassword(userBean.getPassword());
        tUser.setPhoneNumber(userBean.getPhoneNumber());
        tUser.setEmaill(userBean.getEmaill());

        tUserMapper.insert(tUser);
        return new Result(true,"注册成功");
    }
}
