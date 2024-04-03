package com.liantai.domain.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 注册用户请求类
 *
 * @author luHan
 * @create 2024/4/3 14:08
 * @since 1.0.0
 */
@Data
public class RegisterUserRequest {
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    @NotEmpty(message = "密码不能为空")
    private String password;
}
