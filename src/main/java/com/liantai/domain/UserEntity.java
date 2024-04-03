package com.liantai.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author luHan
 * @create 2024/4/3 13:27
 * @since 1.0.0
 */
@Data
public class UserEntity {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
