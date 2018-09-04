package com.junfeng.zuul.service.impl;

import com.junfeng.zuul.bean.ResultBean;
import com.junfeng.zuul.client.UserClient;
import com.junfeng.zuul.vo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author junfeng
 * @Date 2018/9/3 15:33
 * Created by adminstor on 2018/9/3.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserClient userClient;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        user.setUsername(username);
        ResultBean<User> resultBean = userClient.login(user);
        if(resultBean != null){
            User user1 = resultBean.getData();
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            if(user1 != null){
                grantedAuthorities.add(new SimpleGrantedAuthority(user1.getGroupName()));
                return new org.springframework.security.core.userdetails.User(user1.getUsername(), user1.getPassword(), grantedAuthorities);
            }
        }
        throw new UsernameNotFoundException("admin: " + username + " do not exist!");
    }
}
