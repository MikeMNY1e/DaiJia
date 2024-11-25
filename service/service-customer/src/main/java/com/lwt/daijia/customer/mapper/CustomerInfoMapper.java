package com.lwt.daijia.customer.mapper;

import com.lwt.daijia.model.entity.customer.CustomerInfo;
import com.lwt.daijia.model.entity.customer.CustomerLoginInfoVo;
import io.swagger.v3.oas.annotations.Operation;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
public interface CustomerInfoMapper {

    /**
     * 通过openId获取客户信息
     * @param openId
     * @return
     */
    @Operation(summary = "通过openId获取客户信息")
    CustomerInfo getCustomerInfoByOpenId(String openId);


    /**
     * 新增用户信息
     * @param customerInfo
     * @return
     */
    @Operation(summary = "新增用户信息")
    int insert(CustomerInfo customerInfo);


    /**
     * 通过id获取用户信息
     * @param customerId
     * @return
     */
    @Operation(summary = "通过id获取用户信息")
    CustomerLoginInfoVo getCustomerInfoById(Long customerId);
}
