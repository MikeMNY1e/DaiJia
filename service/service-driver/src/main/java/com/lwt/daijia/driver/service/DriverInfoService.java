package com.lwt.daijia.driver.service;

import io.swagger.v3.oas.annotations.Operation;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
public interface DriverInfoService {

    /**
     * 小程序授权登录
     * @param code 微信登录码
     * @return 司机id
     */
    @Operation(summary = "小程序司机登录")
    Long login(String code);
}
