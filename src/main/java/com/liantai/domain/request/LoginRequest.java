package com.liantai.domain.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 登录请求类
 *
 * @author luHan
 * @create 2024/4/3 14:19
 * @since 1.0.0
 */
@Data
public class LoginRequest {
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    @NotEmpty(message = "密码不能为空")
    private String password;
    private Boolean rememberMe;
    private Boolean autoRegister;
}
