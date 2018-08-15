package com.junfeng.blog.repository;


import com.junfeng.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author junfeng
 * @Date 2018/8/2 23:46
 * Created by adminstor on 2018/8/2.
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>, PagingAndSortingRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {

}
