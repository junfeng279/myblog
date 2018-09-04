package com.junfeng.zuul.client;

import com.junfeng.zuul.bean.ResultBean;
import com.junfeng.zuul.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @Author junfeng
 * @Date 2018/9/3 15:04
 * Created by adminstor on 2018/9/3.
 */
@Service
@FeignClient(name = "user")
public interface UserClient {
    @PostMapping("/user")
    ResultBean<User> save(@RequestBody User user);

    @GetMapping("/user/{uid}")
    ResultBean<User> getById(@PathVariable("uid") Integer uid);

    @PostMapping("/user/login")
    ResultBean<User> login(@RequestBody User user);
}
