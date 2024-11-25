package com.lwt.daijia.customer.controller;

import com.lwt.daijia.common.result.ResponseResult;
import com.lwt.daijia.customer.service.CustomerInfoService;
import com.lwt.daijia.model.entity.customer.CustomerLoginInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
@RestController
@RequestMapping("/customer/info")
public class CustomerInfoController {

    @Resource
    private CustomerInfoService customerInfoService;


    @Operation(summary = "小程序授权登录")
    @GetMapping("/login/{code}")
    public ResponseResult<Long> login(@PathVariable String code){
        return ResponseResult.ok(customerInfoService.login(code));
    }


    @Operation(summary = "获取客户登录信息")
    @GetMapping("getCustomerLoginInfo/{customerId}")
    public ResponseResult<CustomerLoginInfoVo> getCustomerLoginInfo(@PathVariable Long customerId){
        return ResponseResult.ok(customerInfoService.getCustomerLoginInfo(customerId));
    }
}
