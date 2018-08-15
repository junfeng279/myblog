package com.junfeng.user.service;

import com.junfeng.user.bean.ResultBean;
import com.junfeng.user.model.User;
import org.springframework.data.domain.Page;

/**
 * @Author junfeng
 * @Date 2018/8/3 22:44
 * Created by adminstor on 2018/8/3.
 */
public interface UserService {
    ResultBean<User> save(User user);

    ResultBean<User> getUserById(Integer uid);

    ResultBean<Page<User>> findAll(Integer page, Integer size);
}
