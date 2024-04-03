package com.liantai.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro相关配置
 *
 * @author luHan
 * @create 2024/4/3 13:14
 * @since 1.0.0
 */
@Configuration
public class ShiroConfig {
    /**
     * 1、Subject：
     * 即“当前操作用户”。它仅仅意味着“当前跟软件交互的东西”。
     * Subject代表了当前用户的安全操作，SecurityManager则管理所有用户的安全操作。
     *
     * 2、SecurityManager：
     * 它是Shiro框架的核心，典型的Facade模式，Shiro通过SecurityManager来管理内部组件实例，并通过它来提供安全管理的各种服务。
     *
     * 3、Realm：
     * Realm充当了Shiro与应用安全数据间的“桥梁”或者“连接器”。当对用户执行认证（登录）和授权（访问控制）验证时，Shiro会从应用配置的Realm中查找用户及其权限信息。
     */

    /**
     * 配置Shiro的安全管理器
     *
     * @Bean： 将对象注入到Spring容器中（类似<bean>标签，放在方法上面）；不指定对象的名称，默认是方法名是 id
     */
    @Bean
    public SecurityManager securityManager(Realm authorizationRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置一个Realm，这个Realm是最终用于完成我们的认证号和授权操作的具体对象
        securityManager.setRealm(authorizationRealm);
        return securityManager;
    }

    /**
     * 配置一个Shiro的过滤器bean，这个bean将配置Shiro相关的一个规则的拦截
     * 如什么样的请求可以访问，什么样的请求不可以访问等等
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        //创建Shiro的拦截的拦截器 ，用于拦截我们的用户请求
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();

        //设置Shiro的安全管理，设置管理的同时也会指定某个Realm 用来完成我们权限分配
        shiroFilter.setSecurityManager(securityManager);
        //用于设置一个登录的请求地址，这个地址可以是一个html或jsp的访问路径，也可以是一个控制器的路径
        //作用是用于通知Shiro我们可以使用这里路径转向到登录页面，但Shiro判断到我们当前的用户没有登录时就会自动转换到这个路径
        //要求用户完成成功
        shiroFilter.setLoginUrl("/");
        //登录成功后转向页面，由于用户的登录后期需要交给Shiro完成，因此就需要通知Shiro登录成功之后返回到那个位置
        shiroFilter.setSuccessUrl("/success");
        //用于指定没有权限的页面，当用户访问某个功能是如果Shiro判断这个用户没有对应的操作权限，那么Shiro就会将请求
        //转向到这个位置，用于提示用户没有操作权限
        shiroFilter.setUnauthorizedUrl("/noPermission");

        //定义一个Map集合，这个Map集合中存放的数据全部都是规则，用于设置通知Shiro什么样的请求可以访问,什么样的请求不可以访问
        Map<String, String> filterChainMap = new LinkedHashMap<String, String>();

        // /login 表示某个请求的名字；anon 表示可以使用游客进行登录（这个请求不需要登录）
        filterChainMap.put("/login", "anon");

        //我们可以在这里配置所有的权限规则，这列数据需要从数据库中读取出来

        //或者在控制器中添加Shiro的注解
//        /**
//         /admin/**  表示一个请求名字的通配， 以admin开头的任意子路径下的所有请求
//         authc 表示这个请求需要进行认证（登录），只有认证（登录）通过才能访问
//         注：
//         ** 表示任意子路径
//         *  表示任意的一个路径
//         ? 表示 任意的一个字符
//         */
//        filterChainMap.put("/admin/**","authc");
//        filterChainMap.put("/user/**","authc");
//
//        //表示所有的请求路径全部都需要被拦截登录，这个必须必须写在Map集合的最后面,这个选项是可选的
//        //如果没有指定/** 那么如果某个请求不符合上面的拦截规则Shiro将方行这个请求
//        filterChainMap.put("/**","authc");

        shiroFilter.setFilterChainDefinitionMap(filterChainMap);

        return shiroFilter;
    }
}