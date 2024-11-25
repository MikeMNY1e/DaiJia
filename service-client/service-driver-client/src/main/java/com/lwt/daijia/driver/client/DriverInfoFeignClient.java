package com.lwt.daijia.driver.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
public interface DriverInfoFeignClient {

    @GetMapping("/driver/info/login/{code}")
    Long login(@PathVariable String code);
}
