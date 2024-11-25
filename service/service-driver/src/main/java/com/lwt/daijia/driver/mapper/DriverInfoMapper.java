package com.lwt.daijia.driver.mapper;

import com.lwt.daijia.model.entity.driver.DriverInfo;
import io.swagger.v3.oas.annotations.Operation;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
public interface DriverInfoMapper {

    /**
     * 通过openId获取司机信息
     * @param openId
     * @return
     */
    @Operation(summary = "通过openId获取司机信息")
    DriverInfo getDriverInfoByOpenId(String openId);


    /**
     * 新增司机信息
     * @param driverInfo
     * @return
     */
    @Operation(summary = "新增司机信息")
    int insert(DriverInfo driverInfo);
}
