package com.lwt.daijia.driver.service.impl;

import com.lwt.daijia.driver.mapper.DriverInfoMapper;
import com.lwt.daijia.driver.mapper.DriverLoginLogMapper;
import com.lwt.daijia.driver.service.DriverInfoService;
import com.lwt.daijia.model.entity.driver.DriverInfo;
import com.lwt.daijia.model.entity.driver.DriverLoginLog;
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
@Service("driverInfoService")
public class DriverInfoServiceImpl implements DriverInfoService {

    @Resource
    private DriverInfoMapper driverInfoMapper;
    @Resource
    private DriverLoginLogMapper driverLoginLogMapper;


    /**
     * 小程序登录
     * @param code 微信登录码
     * @return 司机id
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

        // 通过openId获取司机信息
        DriverInfo driverInfo = driverInfoMapper.getDriverInfoByOpenId(openId);

        // 如果是第一次注册，添加信息到数据库
        if (driverInfo == null) {
            driverInfo = new DriverInfo();
            driverInfo.setNickname(String.valueOf(System.currentTimeMillis()));
            driverInfo.setAvatarUrl("https://oss.aliyuncs.com/aliyun_id_photo_bucket/default_handsome.jpg");
            driverInfo.setWxOpenId(openId);
            driverInfoMapper.insert(driverInfo);

            // 记录日志写入数据库
            DriverLoginLog driverLoginLog = new DriverLoginLog();
            driverLoginLog.setDriverId(driverInfo.getId());
            driverLoginLog.setMsg("司机小程序注册");
            driverLoginLogMapper.insert(driverInfo.getId());
        }

        return driverInfo.getId();
    }
}
