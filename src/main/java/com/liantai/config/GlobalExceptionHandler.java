package com.liantai.config;

import com.liantai.domain.ResponseInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理器
 *
 * @author luHan
 * @create 2024/4/3 14:20
 * @since 1.0.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnknownAccountException.class)
    public ResponseInfo unknownAccountException(UnknownAccountException unknownAccountException) {
        return ResponseInfo.error("10001", unknownAccountException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseInfo exception(Exception exception) {
        return ResponseInfo.error("50000", exception.getMessage());
    }
}
