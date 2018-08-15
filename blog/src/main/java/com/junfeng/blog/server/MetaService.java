package com.junfeng.blog.server;

import com.junfeng.blog.model.Meta;

import java.util.List;

/**
 * @Author junfeng
 * @Date 2018/8/3 20:48
 * Created by adminstor on 2018/8/3.
 */
public interface MetaService {
    List<Meta> findAll();

    Meta save(Meta meta);

    void saveAll(List<Meta> metas);
}
