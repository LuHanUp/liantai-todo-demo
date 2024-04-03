package com.liantai.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用响应结果
 *
 * @author luHan
 * @create 2024/4/3 14:06
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInfo implements Serializable {
    private static final long serialVersionUID = 7550223536063992120L;

    private String errorCode;
    private String message;
    private Object data;

    public static ResponseInfo success() {
        return new ResponseInfo("00000", "请求成功", null);
    }

    public static ResponseInfo success(Object data) {
        return new ResponseInfo("00000", "请求成功", data);
    }

    public static ResponseInfo error(String errorCode,String errorMsg) {
        return new ResponseInfo(errorCode, errorMsg, null);
    }
}
