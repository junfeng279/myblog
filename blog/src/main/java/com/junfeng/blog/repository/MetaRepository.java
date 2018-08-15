package com.junfeng.blog.repository;

import com.junfeng.blog.model.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author junfeng
 * @Date 2018/8/2 23:47
 * Created by adminstor on 2018/8/2.
 */
public interface MetaRepository extends JpaRepository<Meta, Integer>, PagingAndSortingRepository<Meta, Integer> {
    Meta findMetaByName(String name);
}
