package com.ftj.service;

import com.ftj.pojo.Comment;

import java.util.List;

/**
 * Created by fengtj on 2021/8/15 11:29
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
