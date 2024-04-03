package com.liantai.shiro;

import com.liantai.domain.UserEntity;
import com.liantai.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Configuration;

/**
 * 认证授权的自定义realm
 *
 * @author luHan
 * @create 2024/4/3 13:18
 * @since 1.0.0
 */
@Configuration
@RequiredArgsConstructor
public class AuthorizationRealm extends AuthenticatingRealm {
    public final UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        String username = usernamePasswordToken.getUsername();

        UserEntity userEntity = userService.findByUserName(username);

        if (userEntity == null) {
            throw new UnknownAccountException("用户不存在！！！");
        }

        // 设置密码加密方式
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(1);
        this.setCredentialsMatcher(credentialsMatcher);

        return new SimpleAuthenticationInfo(username, userEntity.getPassword(), ByteSource.Util.bytes(userEntity.getSalt()), getName());
    }

}
