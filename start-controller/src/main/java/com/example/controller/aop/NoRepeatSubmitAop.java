package com.example.controller.aop;

import com.example.api.entity.exception.BaseException;
import com.example.api.utils.RedisUtil;
import com.example.controller.anotation.NoRepeatSubmit;
import com.example.controller.utils.ServletUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class NoRepeatSubmitAop {

    private Logger logger = LoggerFactory.getLogger(NoRepeatSubmit.class);

    @Autowired
    private RedisUtil redisUtil;

    @Around(value = "execution(* com.example.controller.controller..*(..)) && @annotation(nrs)")
    public Object around(ProceedingJoinPoint point, NoRepeatSubmit nrs) {
        Map<String, String[]> params = ServletUtils.getRequest().getParameterMap();
        StringBuffer pathBuffer = ServletUtils.getRequest().getRequestURL();
        pathBuffer.append("?");
        params.forEach((key, value) -> {
            pathBuffer.append(key + "=" + value[0].toString() + "&");
        });
        logger.info("---------------------存储的key键"+pathBuffer.toString()+"-------------------------------");
        boolean flag = redisUtil.setnx(pathBuffer.toString(), "1", 60);
        if (flag) {
            try {
                Object obj = point.proceed();
                return obj;
            } catch (Throwable e) {
                e.printStackTrace();
                logger.debug("提交出现异常");
                throw  new BaseException(BaseException.Type.ERROR, "请稍后重试。。。");
            } finally {
                redisUtil.del(pathBuffer.toString());
            }
        } else {
            logger.info("重复提交");
            throw new BaseException(BaseException.Type.ERROR, "请稍等,后台正在处理。。。");
        }
    }
}
