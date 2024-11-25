package com.lwt.daijia.customer.service;

import com.lwt.daijia.model.entity.customer.CustomerLoginInfoVo;
import io.swagger.v3.oas.annotations.Operation;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
public interface CustomerService {

    /**
     * 小程序客户登录
     * @param code
     * @return
     */
    @Operation(summary = "小程序客户登录")
    String login(String code);


    /**
     * 从redis中获取客户id
     * @param token
     * @return
     */
    @Operation(summary = "获取客户id")
    CustomerLoginInfoVo getCustomerLoginInfo(String token);
}
