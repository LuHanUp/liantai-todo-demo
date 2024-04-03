package com.liantai.controller;

import com.liantai.domain.ResponseInfo;
import com.liantai.domain.UserEntity;
import com.liantai.domain.request.LoginRequest;
import com.liantai.domain.request.RegisterUserRequest;
import com.liantai.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息Controller
 *
 * @author luHan
 * @create 2024/4/3 14:05
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * 注册用户
     *
     * @return
     */
    @RequestMapping("/register")
    public ResponseInfo register(@RequestBody RegisterUserRequest request) {
        UserEntity userEntity = userService.register(request);
        return ResponseInfo.success(userEntity);
    }

    @RequestMapping("login")
    public ResponseInfo login(@RequestBody LoginRequest request) {
        userService.login(request);
        return ResponseInfo.success();
    }
}
