package com.junfeng.blog.server;

import com.junfeng.blog.bean.ResultBean;
import com.junfeng.blog.model.Comment;
import org.springframework.data.domain.Page;

/**
 * @Author junfeng
 * @Date 2018/8/3 20:47
 * Created by adminstor on 2018/8/3.
 */
public interface CommentService {

    ResultBean<Page<Comment>> findCommnetByContentId(Integer page, Integer size, Integer cid);

    ResultBean<Comment> save(Comment comment);

}
