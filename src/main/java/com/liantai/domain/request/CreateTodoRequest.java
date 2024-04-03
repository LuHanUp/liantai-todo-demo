package com.liantai.domain.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 删除todo请求
 *
 * @author luHan
 * @create 2024/4/3 14:48
 * @since 1.0.0
 */
@Data
public class CreateTodoRequest {
    @NotEmpty(message = "todo不能为空")
    private String todo;
}
