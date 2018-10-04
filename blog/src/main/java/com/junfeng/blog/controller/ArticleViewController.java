package com.junfeng.blog.controller;

import com.junfeng.blog.bean.ResultBean;
import com.junfeng.blog.model.Comment;
import com.junfeng.blog.model.Content;
import com.junfeng.blog.server.CommentService;
import com.junfeng.blog.server.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Created by junfeng on 18-10-4.
 *
 */
@RestController
@RequestMapping("/blog/view/content")
public class ArticleViewController {
    @Autowired
    private ContentService contentService;

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResultBean<Page<Content>> getAllWithPage(@RequestParam("page") Integer page,
                                                    @RequestParam("pageSize") Integer pageSize){
        return contentService.findAll(page, pageSize);
    }

    @GetMapping("/{cid}")
    public ResultBean<Content> getById(@PathVariable("cid") Integer cid){
        return contentService.findById(cid);
    }


    @PostMapping
    public ResultBean<Comment> save(@RequestBody Comment comment){
        return commentService.save(comment);
    }

    @GetMapping("/comment/{cid}")
    public ResultBean<Page<Comment>> getCommentsByCid(@PathVariable("cid") Integer cid,
                                                      @RequestParam("page") Integer page,
                                                      @RequestParam("pageSize") Integer pageSize){
        return commentService.findCommnetByContentId(page, pageSize, cid);
    }
}
