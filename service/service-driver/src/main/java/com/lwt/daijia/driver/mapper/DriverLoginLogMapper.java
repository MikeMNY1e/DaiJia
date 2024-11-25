package com.lwt.daijia.driver.mapper;

import io.swagger.v3.oas.annotations.Operation;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
public interface DriverLoginLogMapper {

    /**
     * 新增司机登录日志
     * @param id
     * @return
     */
    @Operation(summary = "新增司机登录日志")
    int insert(Long id);
}
