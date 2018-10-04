package com.junfeng.blog.controller;

import com.junfeng.blog.bean.ResultBean;
import com.junfeng.blog.model.Content;
import com.junfeng.blog.server.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    @Value("${file.upload.path}")
    private String fileUploadPath;

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

    @PostMapping("/upload")
    public ResultBean<String> singleFileUpload(@RequestParam("file") MultipartFile file) {
        ResultBean<String>  resultBean = new ResultBean<>();
        if (file.isEmpty()) {
            resultBean.setSuccess(false);
            return resultBean;
        }

        String url = "";
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String name = file.getOriginalFilename();
            String fileName = System.currentTimeMillis() + name.substring(name.lastIndexOf("."), name.length());
            File filePath = new File(fileUploadPath);
            if (false == filePath.exists()) {
                filePath.mkdirs();
            }
            Path path = Paths.get(fileUploadPath + "/" + fileName);
            url = generateUrl(fileName);
            Files.write(path, bytes);
            resultBean.setData(url);
            resultBean.setSuccess(true);
            return resultBean;
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultBean.setSuccess(false);
        return resultBean;
    }

    private String generateUrl(String fileName){
        return "/img/"+fileName;
    }

}
