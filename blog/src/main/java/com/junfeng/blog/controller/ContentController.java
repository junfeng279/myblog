package com.junfeng.blog.controller;

import com.junfeng.blog.bean.ResultBean;
import com.junfeng.blog.model.Content;
import com.junfeng.blog.server.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Author junfeng
 * @Date 2018/8/3 21:30
 * Created by adminstor on 2018/8/3.
 */
@RestController
@RequestMapping("/blog/content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @PostMapping
    public ResultBean<Content> save(@RequestBody Content content){
        return contentService.save(content);
    }

    @GetMapping("/{cid}")
    public ResultBean<Content> getById(@PathVariable("cid") Integer cid){
        return contentService.findById(cid);
    }

    @GetMapping
    public ResultBean<Page<Content>> getAllWithPage(@RequestParam("page") Integer page,
                                                    @RequestParam("pageSize") Integer pageSize){
        return contentService.findAll(page, pageSize);
    }
}
