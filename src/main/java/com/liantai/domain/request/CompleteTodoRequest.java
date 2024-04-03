package com.liantai.domain.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 完成todo请求
 *
 * @author luHan
 * @create 2024/4/3 14:48
 * @since 1.0.0
 */
@Data
public class CompleteTodoRequest {
    @NotEmpty(message = "todoId列表不能为空")
    private List<Long> todoIdList;
}
