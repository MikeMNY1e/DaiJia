package com.lwt.daijia;

import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.lwt.daijia.*.mapper")
@EnableFeignClients
@EnableDiscoveryClient
public class ServiceCustomerApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceCustomerApplication.class, args);
        System.out.println("客户服务启动成功");
    }
}
