package com.lwt.daijia.common.exception;

import com.lwt.daijia.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
@Data
public class GlobalException extends RuntimeException {

    private Integer code;

    private String message;

    /**
     * 通过状态码和错误消息创建异常对象
     * @param code
     * @param message
     */
    public GlobalException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public GlobalException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }
}
