package com.lwt.daijia.customer.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @author lwt
 * @version 1.0.0
 * @description 注入微信小程序服务Bean
 */
@Component
public class WxOperationConfig {

    @Resource
    private WxPropertiesConfig wxPropertiesConfig;


    /**
     * 注入微信小程序服务Bean
     * @return
     */
    @Bean
    public WxMaService wxMaService() {

        // 配置微信小程序的 id 和 密钥
        WxMaDefaultConfigImpl wxMaDefaultConfig = new WxMaDefaultConfigImpl();
        wxMaDefaultConfig.setAppid(wxPropertiesConfig.getAppId());
        wxMaDefaultConfig.setSecret(wxPropertiesConfig.getSecret());

        // 根据配置，初始化微信小程序服务
        WxMaService wxMaService = new WxMaServiceImpl();
        wxMaService.setWxMaConfig(wxMaDefaultConfig);
        return wxMaService;
    }
}
