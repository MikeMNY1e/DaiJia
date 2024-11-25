package com.lwt.daijia.common.authentication;

import com.lwt.daijia.common.constant.RedisConstant;
import com.lwt.daijia.common.exception.GlobalException;
import com.lwt.daijia.common.result.ResultCodeEnum;
import com.lwt.daijia.common.util.AuthContextHolder;
import jakarta.annotation.Resource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
@Component
@Aspect
public class LoginAuthenticationAspect {

    @Resource
    private RedisTemplate redisTemplate;


    @Around("@annotation(LoginAuthentication)")
    public Object loginAuthentication(ProceedingJoinPoint joinPoint) throws Throwable {

        // 从请求头中获取token
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        String token = servletRequestAttributes.getRequest().getHeader("token");

        if (!StringUtils.hasText(token)) {
            throw new GlobalException(ResultCodeEnum.NOT_LOGIN);
        }

        Object userIdObj = redisTemplate.opsForValue().get(RedisConstant.USER_LOGIN_KEY_PREFIX + token);
        if (userIdObj == null) {
            throw new GlobalException(ResultCodeEnum.NOT_LOGIN);
        }
        String userId = userIdObj.toString();

        if (StringUtils.hasText(userId)) {
            AuthContextHolder.setUserId(Long.parseLong(userId));
        }

        return joinPoint.proceed();
    }
}
