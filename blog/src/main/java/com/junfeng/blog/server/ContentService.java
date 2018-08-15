package com.junfeng.blog.server;

import com.junfeng.blog.bean.ResultBean;
import com.junfeng.blog.model.Content;
import org.springframework.data.domain.Page;

/**
 * @Author junfeng
 * @Date 2018/8/3 20:48
 * Created by adminstor on 2018/8/3.
 */
public interface ContentService {
    ResultBean<Page<Content>> findAll(Integer page, Integer size);

    ResultBean<Content> findById(Integer cid);

    ResultBean<Content> save(Content content);

}
