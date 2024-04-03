package com.liantai.mapper;

import com.liantai.domain.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author luHan
 * @create 2024/4/3 13:32
 * @since 1.0.0
 */
@Mapper
public interface UserMapper {

    /**
     * 通过用户名称获取用户信息
     *
     * @param username 用户名称
     * @return
     */
    UserEntity findByUserName(@Param("username") String username);

    /**
     * 添加用户信息
     *
     * @param userEntity
     */
    void insert(UserEntity userEntity);
}
