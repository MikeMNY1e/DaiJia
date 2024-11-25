package com.lwt.daijia.customer.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.lwt.daijia.customer.mapper.CustomerInfoMapper;
import com.lwt.daijia.customer.mapper.CustomerLoginLogMapper;
import com.lwt.daijia.customer.service.CustomerInfoService;
import com.lwt.daijia.model.entity.customer.CustomerInfo;
import com.lwt.daijia.model.entity.customer.CustomerLoginLog;
import com.lwt.daijia.model.entity.customer.CustomerLoginInfoVo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
@Slf4j
@Service("customerInfoService")
public class CustomerInfoServiceImpl implements CustomerInfoService {

    @Resource
    private WxMaService wxMaService;

    @Resource
    private CustomerInfoMapper customerInfoMapper;
    @Resource
    private CustomerLoginLogMapper customerLoginLogMapper;


    /**
     * 小程序授权登录
     * @param code 微信登录码
     * @return 客户id
     */
    @Override
    public Long login(String code) {

        // 获取OpenId
        String openId = null;

        try {

//            WxMaJscode2SessionResult sessionInfo = wxMaService.getUserService().getSessionInfo(code);
//            openId = sessionInfo.getOpenid();
            openId = "openId" + code;
            log.info("【小程序授权】openid={}", openId);

        } catch (/*WxError*/Exception e) {
            throw new RuntimeException(e);
        }

        // 通过openId获取客户信息
        CustomerInfo customerInfo = customerInfoMapper.getCustomerInfoByOpenId(openId);

        // 如果是第一次登录，添加信息
        if (customerInfo == null) {
            customerInfo = new CustomerInfo();
            customerInfo.setNickname(String.valueOf(System.currentTimeMillis()));
            customerInfo.setAvatarUrl("https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
            customerInfo.setWxOpenId(openId);
            customerInfo.setCreateTime(new Date());
            customerInfo.setGender("1");
            customerInfoMapper.insert(customerInfo);

            // 记录日志写入数据库
            CustomerLoginLog customerLoginLog = new CustomerLoginLog();
            customerLoginLog.setCustomerId(customerInfo.getId());
            customerLoginLog.setMsg("客户小程序注册");
            customerLoginLog.setCreateTime(new Date());
            customerLoginLogMapper.insert(customerLoginLog);
        }

        return customerInfo.getId();
    }


    /**
     * 获取客户登录信息
     * @param customerId 客户id
     * @return 客户登录信息
     */
    @Override
    public CustomerLoginInfoVo getCustomerLoginInfo(Long customerId) {

        return customerInfoMapper.getCustomerInfoById(customerId);
    }
}
