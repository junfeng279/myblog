package com.junfeng.blog.controller;

import com.junfeng.blog.bean.ResultBean;
import com.junfeng.blog.model.Comment;
import com.junfeng.blog.server.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Author junfeng
 * @Date 2018/8/3 22:17
 * Created by adminstor on 2018/8/3.
 */
@RestController
@RequestMapping("/blog/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResultBean<Comment> save(@RequestBody Comment comment){
        return commentService.save(comment);
    }

    @GetMapping("/content/{cid}")
    public ResultBean<Page<Comment>> getCommentsByCid(@PathVariable("cid") Integer cid,
                                                      @RequestParam("page") Integer page,
                                                      @RequestParam("pageSize") Integer pageSize){
        return commentService.findCommnetByContentId(page, pageSize, cid);
    }
}
