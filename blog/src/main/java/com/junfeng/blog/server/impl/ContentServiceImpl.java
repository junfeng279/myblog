package com.junfeng.blog.server.impl;

import com.junfeng.blog.bean.ResultBean;
import com.junfeng.blog.model.Content;
import com.junfeng.blog.model.Meta;
import com.junfeng.blog.repository.ContentRepository;
import com.junfeng.blog.repository.MetaRepository;
import com.junfeng.blog.server.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author junfeng
 * @Date 2018/8/3 21:04
 * Created by adminstor on 2018/8/3.
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Resource
    private ContentRepository contentRepository;
    @Resource
    private MetaRepository metaRepository;
    @Override
    public ResultBean<Page<Content>> findAll(Integer page, Integer size) {
        ResultBean<Page<Content>> resultBean = new ResultBean<>();
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "cid");
        Page<Content> res = contentRepository.findAll(pageable);
        resultBean.setData(res);
        resultBean.setSuccess(true);
        return resultBean;
    }

    @Override
    public ResultBean<Content> findById(Integer cid) {
        ResultBean<Content> resultBean = new ResultBean<>();
        Optional<Content>  c = contentRepository.findById(cid);
        resultBean.setData(c.get());
        resultBean.setSuccess(true);
        return resultBean;
    }

    @Override
    public ResultBean<Content> save(Content content) {
        ResultBean<Content> resultBean = new ResultBean<>();
        if(Objects.isNull(content)){
            resultBean.setMsg("没有添加文章信息;");
        }
        if(StringUtils.isEmpty(content.getTitle())){
            resultBean.setMsg("请填写标题信息;");
        }
        if(StringUtils.isEmpty(content.getContent())){
            resultBean.setMsg("请填写内容信息;");
        }
        if(!StringUtils.isEmpty(content.getTags())){
            String[] tags = content.getTags().split(",");
            //保存所有标签信息
            saveTags(tags);
        }
        if(!StringUtils.isEmpty(content.getCategories())){
            String[] categories = content.getCategories().split(",");
            //保存所有标签信息
            saveCategory(categories);
        }
        content.setAuthorId(1);
        content.setCommentsNum(0);
        content.setHit(0);
        content.setStatus("DRAFT");
        content.setType("PUBLISH");
        content.setCreated(new Date().getTime());
        content.setModified(new Date().getTime());
        resultBean.setData(contentRepository.save(content));
        resultBean.setSuccess(true);
        return resultBean;
    }

    /**
     * 保存文章对应的标签信息
     * @param tags
     */
    public void saveTags(String[] tags) {
        List<String> list = Arrays.asList(tags);
        List<Meta> metas = list.stream().map(tag -> {
            Meta meta = new Meta();
            meta.setName(tag);
            meta.setDescription(tag);
            meta.setType("TAG");
            return meta;
        }).collect(Collectors.toList());
        metaRepository.saveAll(metas);
    }
    /**
     * 保存文章对应的标签信息
     * @param categories
     */
    public void saveCategory(String[] categories) {
        List<String> list = Arrays.asList(categories);
        List<Meta> metas = list.stream().map(tag -> {
            Meta meta = new Meta();
            meta.setName(tag);
            meta.setDescription(tag);
            meta.setType("CATEGORY");
            return meta;
        }).collect(Collectors.toList());
        metaRepository.saveAll(metas);
    }
}
