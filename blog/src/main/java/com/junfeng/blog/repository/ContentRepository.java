package com.junfeng.blog.repository;

import com.junfeng.blog.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author junfeng
 * @Date 2018/8/2 23:47
 * Created by adminstor on 2018/8/2.
 */
public interface ContentRepository extends JpaRepository<Content, Integer>, PagingAndSortingRepository<Content, Integer> {

}
