package com.lwt.daijia.model.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 客户表(CustomerInfo)实体类
 *
 * @author makejava
 * @since 2024-11-15 16:18:24
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerInfo implements Serializable {
    private static final long serialVersionUID = -52037798769353411L;
/**
     * 主键
     */
    private Long id;
/**
     * 微信openId
     */
    private String wxOpenId;
/**
     * 客户昵称
     */
    private String nickname;
/**
     * 性别
     */
    private String gender;
/**
     * 头像
     */
    private String avatarUrl;
/**
     * 电话
     */
    private String phone;
/**
     * 1有效，2禁用
     */
    private Integer status;
/**
     * 创建时间
     */
    private Date createTime;

    private Date updateTime;

    private Integer isDeleted;
}