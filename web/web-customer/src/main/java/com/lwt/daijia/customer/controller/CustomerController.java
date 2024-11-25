package com.lwt.daijia.customer.controller;

import com.lwt.daijia.common.authentication.LoginAuthentication;
import com.lwt.daijia.common.result.ResponseResult;
import com.lwt.daijia.customer.service.CustomerService;
import com.lwt.daijia.model.entity.customer.CustomerLoginInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
@Tag(name = "客户API接口管理")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;


    @GetMapping("/login/{code}")
    @Operation(summary = "小程序微信登录")
    public ResponseResult<String> wxLogin(@PathVariable String code) {
        return ResponseResult.ok(customerService.login(code));
    }


    @GetMapping("/getCustomerLoginInfo/{customerId}")
    @Operation(summary = "获取客户登录信息")
    @LoginAuthentication
    public ResponseResult<CustomerLoginInfoVo> getCustomerLoginInfo(@RequestHeader("token") String token) {

        return ResponseResult.ok(customerService.getCustomerLoginInfo(token));
    }
}
