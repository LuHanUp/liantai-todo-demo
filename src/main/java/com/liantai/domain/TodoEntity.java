package com.liantai.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author luHan
 * @create 2024/4/3 13:27
 * @since 1.0.0
 */
@Data
public class TodoEntity {
    /**
     * 主键id
     */
    private Long id;

    /**
     * todo事项
     */
    private String todo;

    /**
     * 是否完成
     */
    private Boolean completed;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
