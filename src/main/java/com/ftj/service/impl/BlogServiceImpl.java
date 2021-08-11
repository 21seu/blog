package com.ftj.service.impl;

import com.ftj.NotFoundException;
import com.ftj.dao.BlogRepository;
import com.ftj.pojo.Blog;
import com.ftj.pojo.Type;
import com.ftj.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengtj on 2021/8/10 23:26
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlog(Long id) {
        return blogRepository.getOne(id);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable, Blog blog) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList();
                if (!StringUtils.isEmpty(blog.getTitle()))
                    predicateList.add(cb.like(root.<String>get("title"), "%" + blog.getTitle() + "%"));
                if (blog.getType().getId() != null)
                    predicateList.add(cb.equal(root.<Type>get("type").get("id"), blog.getType().getId()));
                if (blog.isRecommend()) predicateList.add(cb.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
                cq.where(predicateList.toArray(new Predicate[predicateList.size()]));
                return null;
            }
        }, pageable);
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog b = blogRepository.getOne(id);
        if (b == null) {
            throw new NotFoundException("该博客不存在");
        }
        BeanUtils.copyProperties(blog, b);
        return blogRepository.save(b);
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
