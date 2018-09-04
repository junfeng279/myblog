package com.junfeng.zuul.service;

import com.junfeng.zuul.vo.User;

/**
 * @Author junfeng
 * @Date 2018/9/3 15:21
 * Created by adminstor on 2018/9/3.
 */
public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */
    User register(User user);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    String login(String username, String password);

    /**
     * token刷新
     * @param oldToken 旧token
     * @return
     */
    String refresh(String oldToken);

}
