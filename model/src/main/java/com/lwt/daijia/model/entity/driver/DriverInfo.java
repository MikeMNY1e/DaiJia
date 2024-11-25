package com.lwt.daijia.model.entity.driver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 司机表(DriverInfo)实体类
 *
 * @author makejava
 * @since 2024-11-19 16:04:08
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverInfo implements Serializable {
    private static final long serialVersionUID = 106592159774892563L;
/**
     * 主键
     */
    private Long id;
/**
     * 微信openId
     */
    private String wxOpenId;
/**
     * 昵称
     */
    private String nickname;
/**
     * 头像
     */
    private String avatarUrl;
/**
     * 电话
     */
    private String phone;
/**
     * 姓名
     */
    private String name;
/**
     * 性别 1:男 2：女
     */
    private String gender;
/**
     * 生日
     */
    private Date birthday;
/**
     * 身份证号码
     */
    private String idcardNo;
/**
     * 身份证地址
     */
    private String idcardAddress;
/**
     * 身份证有效期
     */
    private Date idcardExpire;
/**
     * 身份证正面
     */
    private String idcardFrontUrl;
/**
     * 身份证背面
     */
    private String idcardBackUrl;
/**
     * 手持身份证
     */
    private String idcardHandUrl;
/**
     * 准驾车型
     */
    private String driverLicenseClass;
/**
     * 驾驶证证件号
     */
    private String driverLicenseNo;
/**
     * 驾驶证有效期
     */
    private Date driverLicenseExpire;
/**
     * 驾驶证初次领证日期
     */
    private Date driverLicenseIssueDate;
/**
     * 驾驶证正面
     */
    private String driverLicenseFrontUrl;
/**
     * 行驶证副页正面
     */
    private String driverLicenseBackUrl;
/**
     * 手持驾驶证
     */
    private String driverLicenseHandUrl;
/**
     * 紧急联系人
     */
    private String contactName;
/**
     * 紧急联系人电话
     */
    private String contactPhone;
/**
     * 紧急联系人关系
     */
    private String contactRelationship;
/**
     * 腾讯云人脸模型id
     */
    private String faceModelId;
/**
     * 司机工号
     */
    private String jobNo;
/**
     * 评分
     */
    private Double score;
/**
     * 订单量统计
     */
    private Integer orderCount;
/**
     * 认证状态 0:未认证  1：审核中 2：认证通过 -1：认证未通过
     */
    private Integer authStatus;
/**
     * 状态，1正常，2禁用
     */
    private Integer status;
/**
     * 创建时间
     */
    private Date createTime;

    private Date updateTime;

    private Integer isDeleted;
}