package com.lwt.daijia.model.entity.driver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 司机登录记录(DriverLoginLog)实体类
 *
 * @author makejava
 * @since 2024-11-19 16:14:12
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverLoginLog implements Serializable {
    private static final long serialVersionUID = -25816277554884506L;
/**
     * 访问ID
     */
    private Long id;
/**
     * 司机id
     */
    private Long driverId;
/**
     * 登录IP地址
     */
    private String ipaddr;
/**
     * 登录状态（0成功 1失败）
     */
    private Integer status;
/**
     * 提示信息
     */
    private String msg;

    private Date createTime;

    private Date updateTime;
/**
     * 删除标记（0:不可用 1:可用）
     */
    private Integer isDeleted;
}