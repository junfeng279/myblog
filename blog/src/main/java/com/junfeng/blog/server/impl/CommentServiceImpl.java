package com.junfeng.blog.server.impl;

import com.junfeng.blog.bean.ResultBean;
import com.junfeng.blog.model.Comment;
import com.junfeng.blog.repository.CommentRepository;
import com.junfeng.blog.server.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.Objects;

/**
 * @Author junfeng
 * @Date 2018/8/3 21:11
 * Created by adminstor on 2018/8/3.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentRepository commentRepository;
    @Override
    public  ResultBean<Page<Comment>> findCommnetByContentId(Integer page, Integer size, Integer cid) {
        ResultBean<Page<Comment>> resultBean = new ResultBean<>();
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "coid");
        Page<Comment> pageComment =  commentRepository.findAll((Specification<Comment>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate p1 = criteriaBuilder.equal(root.get("cid").as(Integer.class), cid);
            criteriaQuery.where(criteriaBuilder.and(p1));
            return criteriaQuery.getRestriction();
        }, pageable);
        resultBean.setData(pageComment);
        resultBean.setSuccess(true);
        return resultBean;
    }

    @Override
    public ResultBean<Comment> save(Comment comment) {
        ResultBean<Comment> resultBean = new ResultBean<>();
        if(Objects.isNull(comment)){
            resultBean.setMsg("评论不能为空!");
            return resultBean;
        }
        if(Objects.isNull(comment.getCid())){
            resultBean.setMsg("评论的文章不能为空！");
            return resultBean;
        }
        if(StringUtils.isEmpty(comment.getContent())){
            resultBean.setMsg("评论内容不能为空!");
            return resultBean;
        }
        comment.setType("COMMENT");
        comment.setCreated(new Date().getTime());
        resultBean.setData(commentRepository.save(comment));
        resultBean.setSuccess(true);
        return resultBean;
    }
}
