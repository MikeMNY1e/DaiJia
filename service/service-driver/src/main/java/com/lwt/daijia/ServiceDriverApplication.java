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
@EnableFeignClients
@EnableDiscoveryClient
public class ServiceDriverApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServiceDriverApplication.class, args);
        System.out.println("司机端服务启动成功");
    }
}