package com.lwt.daijia.customer.client;

import com.lwt.daijia.common.result.ResponseResult;
import com.lwt.daijia.model.entity.customer.CustomerLoginInfoVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
@FeignClient(value = "service-customer")
public interface CustomerInfoFeignClient {

    @GetMapping("/customer/info/login/{code}")
    public ResponseResult<Long> login(@PathVariable String code);

    @GetMapping("/customer/info/getCustomerLoginInfo/{customerId}")
    public ResponseResult<CustomerLoginInfoVo> getCustomerLoginInfo(@PathVariable Long customerId);
}
