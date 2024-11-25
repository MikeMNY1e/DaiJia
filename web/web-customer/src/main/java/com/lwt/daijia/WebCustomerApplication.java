package com.lwt.daijia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //取消数据源自动配置
@EnableDiscoveryClient
@EnableFeignClients
public class WebCustomerApplication {

    public static void main(String[] args) {

        SpringApplication.run(WebCustomerApplication.class, args);
        System.out.println("客户端Web服务启动成功");
    }
}
