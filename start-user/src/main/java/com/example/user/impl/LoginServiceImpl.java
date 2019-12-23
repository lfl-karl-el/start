package com.example.user.impl;

import com.example.api.service.LoginService;
import com.example.api.utils.RabbitMQConfig;
import com.example.api.utils.RedisUtil;
import com.example.api.utils.Result;
import com.example.user.dao.TUserMapper;
import com.example.user.dao.TVericodeMapper;
import com.example.user.entity.TUser;
import com.example.user.entity.TVericode;
import com.example.user.utils.BaseUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: start-LoginServiceImpl
 * @description: 登陆接口
 * @author: Mr.lfl
 * @create: 2019-01-07 16:39
 **/
@Service("loginService")
public class LoginServiceImpl implements LoginService{

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    RedisUtil redisUtil;

    @Resource
    private TUserMapper tUserMapper;

    @Resource
    private TVericodeMapper tVericodeMapper;

    @Override
    public Result login(String userName,String password){

        TUser tUser = new TUser();
        tUser.setUserName(userName);
        tUser.setPassword(password);
        List<TUser> userList = tUserMapper.selectAllUser(tUser);
        if(userList.size() == 1){
            //统计每天工号的是否登记 采用redis里面的setbit和
            getLoginNumber(userList.get(0).getUserId());
            return new Result(true,"成功登录",userList.get(0));
        }
        return new Result(false,"登录失败");
    }

    @Override
    public Result phoneLogin(String phoneNumber, String veriCode) {
        //去redis里面获取验证码
        String code = (String)redisUtil.get("veriCode"+phoneNumber);
        if(code == null){
            return new Result(false,"验证码失效，请重新发送");
        }

        if(!code.equals(veriCode)){
            return new Result(false,"验证码输入错误");
        }
//        getLoginNumber(Long.parseLong(phoneNumber));
        return new Result(true,"登录成功");
    }

    @Override
    public Result sendVeriCode(String phoneNumber){
        try {
            String veriCode = BaseUtils.randomNumber(6);
            TVericode tVericode = new TVericode();
            tVericode.setCodeNumber(veriCode);
            tVericode.setPhoneNumber(phoneNumber);
            tVericode.setCreateTime(new Timestamp(new Date().getTime()));

            //发送短信 这里放入队列，用存表的方式取代发送短信
            amqpTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE,RabbitMQConfig.BINDING_KEY_VERICODE,tVericodeMapper.insert(tVericode));
            //存入redis 时限设置为1分钟
            redisUtil.set("veriCode"+phoneNumber,veriCode,60);
        }catch (Exception e){
            return new Result(false,"验证码发送失败");
        }
        return new Result(true,"验证码发送成功");
    }

    /**
     * 对每天登录的用户做统计
     */
    public void getLoginNumber(long userId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String time = sdf.format(new Date());

        StringBuffer stringBuffer = new StringBuffer("Login");
        String key = stringBuffer.append(time).toString();

        redisUtil.setBit(key,userId,true);
    }

}
