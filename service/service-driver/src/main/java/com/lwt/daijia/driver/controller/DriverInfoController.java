package com.lwt.daijia.driver.controller;

import com.lwt.daijia.common.result.ResponseResult;
import com.lwt.daijia.driver.service.DriverInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "司机API接口管理")
@RestController
@RequestMapping("/driver/info")
public class DriverInfoController {

    @Resource
    private DriverInfoService driverInfoService;

    @Operation(summary = "小程序授权登录")
    @GetMapping("/login/{code}")
    public ResponseResult<Long> login(@PathVariable String code) {
        return ResponseResult.ok(driverInfoService.login(code));
    }
}
