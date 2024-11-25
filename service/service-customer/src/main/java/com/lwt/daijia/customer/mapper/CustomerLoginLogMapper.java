package com.lwt.daijia.customer.mapper;

import com.lwt.daijia.model.entity.customer.CustomerLoginLog;
import io.swagger.v3.oas.annotations.Operation;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
public interface CustomerLoginLogMapper {

    /**
     * 新增客户登录日志
     * @param customerLoginLog
     * @return
     */
    @Operation(summary = "新增客户登录日志")
    int insert(CustomerLoginLog customerLoginLog);
}
