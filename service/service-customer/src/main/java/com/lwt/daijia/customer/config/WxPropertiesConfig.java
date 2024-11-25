package com.lwt.daijia.customer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lwt
 * @version 1.0.0
 * @description 微信小程序配置,获取小程序id和密钥
 */
@Component
@Data
@ConfigurationProperties("wx.miniapp")
public class WxPropertiesConfig {


    /**
     * 小程序id
     */
    private String appId;

    /**
     * 小程序密钥
     */
    private String secret;
}
