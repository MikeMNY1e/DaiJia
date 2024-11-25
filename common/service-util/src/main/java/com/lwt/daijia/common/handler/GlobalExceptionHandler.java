package com.lwt.daijia.common.handler;

import com.lwt.daijia.common.exception.GlobalException;
import com.lwt.daijia.common.result.ResponseResult;
import com.lwt.daijia.common.result.ResultCodeEnum;
import feign.codec.DecodeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lwt
 * @version 1.0.0
 * @description 全局异常处理类
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseResult<Void> error(Exception e){
        e.printStackTrace();
        return ResponseResult.fail();
    }

    /**
     * 自定义异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(GlobalException.class)
    public ResponseResult<Void> error(GlobalException e){
        e.printStackTrace();
        return ResponseResult.build(null, e.getCode(), e.getMessage());
    }

    @ExceptionHandler(DecodeException.class)
    public ResponseResult<Void> error(DecodeException e){
        e.printStackTrace();
        return ResponseResult.build(null, e.status(), e.getMessage());
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseResult<Void> illegalArgumentException(Exception e) {
        e.printStackTrace();
        log.error("触发异常拦截: " + e.getMessage(), e);
        return ResponseResult.build(null, ResultCodeEnum.ARGUMENT_VALID_ERROR);
    }

//    /**
//     * spring security异常
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(AccessDeniedException.class)
//    @ResponseBody
//    public Result error(AccessDeniedException e) throws AccessDeniedException {
//        return Result.build(null, ResultCodeEnum.PERMISSION);
//    }

    @ExceptionHandler(value = BindException.class)
    public ResponseResult<Map<String, Object>> error(org.springframework.validation.BindException exception) {
        BindingResult result = exception.getBindingResult();
        Map<String, Object> errorMap = new HashMap<>();
        List<FieldError> fieldErrors = result.getFieldErrors();
        fieldErrors.forEach(error -> {
            log.error("field: " + error.getField() + ", msg:" + error.getDefaultMessage());
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseResult.build(errorMap, ResultCodeEnum.ARGUMENT_VALID_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult<Map<String, Object>> error(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        Map<String, Object> errorMap = new HashMap<>();
        List<FieldError> fieldErrors = result.getFieldErrors();
        fieldErrors.forEach(error -> {
            log.error("field: " + error.getField() + ", msg:" + error.getDefaultMessage());
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseResult.build(errorMap, ResultCodeEnum.ARGUMENT_VALID_ERROR);
    }
}
