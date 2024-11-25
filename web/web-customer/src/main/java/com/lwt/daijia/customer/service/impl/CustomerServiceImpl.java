package com.lwt.daijia.customer.service.impl;

import com.lwt.daijia.common.constant.RedisConstant;
import com.lwt.daijia.common.exception.GlobalException;
import com.lwt.daijia.common.result.ResponseResult;
import com.lwt.daijia.common.result.ResultCodeEnum;
import com.lwt.daijia.common.util.AuthContextHolder;
import com.lwt.daijia.customer.client.CustomerInfoFeignClient;
import com.lwt.daijia.customer.service.CustomerService;
import com.lwt.daijia.model.entity.customer.CustomerLoginInfoVo;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private RedisTemplate redisTemplate;

    // 远程调用服务接口
    @Resource
    private CustomerInfoFeignClient customerInfoFeignClient;


    /**
     * 微信登录
     * @param code
     * @return
     */
    @Override
    public String login(String code) {

        // 调用远程服务，获取返回信息
        ResponseResult<Long> result = customerInfoFeignClient.login(code);
        System.out.println(result);
        if (result.getCode() != 200) {
            throw new GlobalException(result.getCode(), result.getMsg());
        }

        // 判断是否获取到用户id
        Long customerId = result.getData();
        if (customerId == null) {
            throw new GlobalException(ResultCodeEnum.DATA_ERROR);
        }

        // 生成token
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        // 保存到redis
        redisTemplate.opsForValue().set(RedisConstant.USER_LOGIN_KEY_PREFIX + token,
                                            customerId,
                                            RedisConstant.USER_LOGIN_KEY_TIMEOUT,
                                            TimeUnit.SECONDS);

        return token;
    }


    /**
     * 从redis中获取用户id
     * @param token
     * @return
     */
    @Override
    public CustomerLoginInfoVo getCustomerLoginInfo(String token) {

        // 获取客户id
        String customerId = AuthContextHolder.getUserId().toString();

        if (!StringUtils.hasText(customerId)) {
            throw new GlobalException(ResultCodeEnum.DATA_ERROR);
        }

        // 调用远程服务，获取用户信息
        ResponseResult<CustomerLoginInfoVo> customerLoginInfo =
                customerInfoFeignClient.getCustomerLoginInfo(Long.parseLong(customerId));

        if (customerLoginInfo.getCode() != 200) {
            throw new GlobalException(ResultCodeEnum.DATA_ERROR);
        }

        CustomerLoginInfoVo customerLoginVo = customerLoginInfo.getData();
        if (customerLoginVo == null) {
            throw new GlobalException(ResultCodeEnum.DATA_ERROR);
        }

        return customerLoginVo;
    }
}
