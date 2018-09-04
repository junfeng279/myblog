package com.junfeng.zuul.controller;

import com.junfeng.zuul.bean.ResultBean;
import com.junfeng.zuul.service.UserService;
import com.junfeng.zuul.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author junfeng
 * @Date 2018/9/3 16:01
 * Created by adminstor on 2018/9/3.
 */
@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Value("${jwt.header}")
    private String tokenHeader;

    @PostMapping("/auth/login")
    public ResultBean<String> login(@RequestBody User user){
        ResultBean<String> resultBean = new ResultBean<>();
        final String token = userService.login(user.getUsername(), user.getPassword());
        resultBean.setSuccess(true);
        resultBean.setData(token);
        return resultBean;
    }

    @PostMapping("/auth/register")
    public ResultBean<User> register(@RequestBody User user){
        ResultBean<User> resultBean = new ResultBean<>();
        resultBean.setSuccess(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        resultBean.setData(userService.register(user));
        return resultBean;
    }

    @GetMapping("/auth/refresh")
    public ResultBean<String> refresh(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        ResultBean<String> resultBean = new ResultBean<>();
        resultBean.setSuccess(true);
        resultBean.setData(userService.refresh(token));
        return resultBean;
    }
}
