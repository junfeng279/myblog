package com.junfeng.user.controller;

import com.junfeng.user.bean.ResultBean;
import com.junfeng.user.model.User;
import com.junfeng.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;

/**
 * @Author junfeng
 * @Date 2018/8/3 23:03
 * Created by adminstor on 2018/8/3.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResultBean<User> save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/{uid}")
    public ResultBean<User> getById(@PathVariable("uid") Integer uid){
        return userService.getUserById(uid);
    }

    @GetMapping
    public ResultBean<Page<User>> getAllWithPage(@RequestParam("page") Integer page,
                                                    @RequestParam("pageSize") Integer pageSize){
        return userService.findAll(page, pageSize);
    }

    @PostMapping("/login")
    public ResultBean<User> login(@RequestBody User user){
        return userService.login(user);
    }
}
