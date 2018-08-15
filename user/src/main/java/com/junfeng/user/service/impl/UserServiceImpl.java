package com.junfeng.user.service.impl;

import com.junfeng.user.bean.ResultBean;
import com.junfeng.user.model.User;
import com.junfeng.user.repository.UserRepository;
import com.junfeng.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author junfeng
 * @Date 2018/8/3 22:59
 * Created by adminstor on 2018/8/3.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Override
    public ResultBean<User> save(User user) {
        ResultBean<User> resultBean = new ResultBean<>();
        resultBean.setData(userRepository.save(user));
        resultBean.setSuccess(true);
        return resultBean;
    }

    @Override
    public ResultBean<User> getUserById(Integer uid) {
        ResultBean<User> resultBean =  new ResultBean<>();
        resultBean.setData(userRepository.findById(uid).get());
        resultBean.setSuccess(true);
        return resultBean;
    }

    @Override
    public ResultBean<Page<User>> findAll(Integer page, Integer size) {
        ResultBean<Page<User>> resultBean = new ResultBean<>();
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "uid");
        userRepository.findAll(pageable);
        Page<User> res = userRepository.findAll(pageable);
        resultBean.setData(res);
        resultBean.setSuccess(true);
        return resultBean;
    }
}
