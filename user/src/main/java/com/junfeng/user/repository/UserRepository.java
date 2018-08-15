package com.junfeng.user.repository;

import com.junfeng.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author junfeng
 * @Date 2018/8/3 22:37
 * Created by adminstor on 2018/8/3.
 */
public interface UserRepository  extends JpaRepository<User, Integer>, PagingAndSortingRepository<User, Integer> {
}
