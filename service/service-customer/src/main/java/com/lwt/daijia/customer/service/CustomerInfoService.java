package com.lwt.daijia.customer.service;

import com.lwt.daijia.model.entity.customer.CustomerLoginInfoVo;
import io.swagger.v3.oas.annotations.Operation;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
public interface CustomerInfoService {

    /**
     * 小程序授权登录
     * @param code 微信登录码
     * @return 客户idid
     */
    @Operation(summary = "小程序客户登录")
    Long login(String code);


    /**
     * 获取客户登录信息
     * @param customerId
     * @return
     */
    @Operation(summary = "获取客户登录信息")
    CustomerLoginInfoVo getCustomerLoginInfo(Long customerId);
}
