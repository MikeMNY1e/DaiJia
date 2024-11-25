package com.lwt.daijia.model.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 客户登录记录(CustomerLoginLog)实体类
 *
 * @author makejava
 * @since 2024-11-15 16:36:07
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerLoginLog implements Serializable {
    private static final long serialVersionUID = 789616465480130722L;
/**
     * 访问ID
     */
    private Long id;
/**
     * 客户id
     */
    private Long customerId;
/**
     * 登录IP地址
     */
    private String ipaddr;
/**
     * 登录状态
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