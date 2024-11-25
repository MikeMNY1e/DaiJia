package com.lwt.daijia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceCouponApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceCouponApplication.class, args);
        System.out.println("优惠券服务启动成功");
    }
}
