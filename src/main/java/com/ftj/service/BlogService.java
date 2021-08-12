package com.ftj.service;

import com.ftj.pojo.Blog;
import com.ftj.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by fengtj on 2021/8/10 0:33
 */
public interface BlogService {

    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);
}
