package com.lwt.daijia.common.result;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(201,"失败"),
    NOT_LOGIN(208, "未登录"),
    DATA_ERROR(204, "数据异常"),
    ARGUMENT_VALID_ERROR(210, "参数校验异常"),
    SYSTEM_ERROR(400,"系统异常");

    private Integer code;
    private String message;
    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}