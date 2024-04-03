package com.liantai.service;

import com.liantai.domain.UserEntity;
import com.liantai.domain.request.LoginRequest;
import com.liantai.domain.request.RegisterUserRequest;
import com.liantai.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

/**
 * @author luHan
 * @create 2024/4/3 13:48
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    /**
     * 通过用户名称获取用户信息
     *
     * @param username 用户名称
     * @return
     */
    public UserEntity findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    /**
     * 注册用户
     *
     * @param request
     * @return
     */
    public UserEntity register(RegisterUserRequest request) {

        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        SimpleHash simpleHash = new SimpleHash("MD5", request.getPassword(), salt, 1);


        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(request.getUserName());
        userEntity.setPassword(simpleHash.toString());
        userEntity.setSalt(salt);

        userMapper.insert(userEntity);

        return userEntity;
    }

    public UserEntity login(LoginRequest request) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(request.getUserName(), request.getPassword(), request.getRememberMe());
        try {
            SecurityUtils.getSubject().login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            if (BooleanUtils.isTrue(request.getAutoRegister())) {
                // 自动执行注册和登录
                RegisterUserRequest registerUserRequest = new RegisterUserRequest();
                UserEntity userEntity = register(registerUserRequest);
                login(request);
                return userEntity;
            }
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(request.getUserName());
        return userEntity;
    }
}
