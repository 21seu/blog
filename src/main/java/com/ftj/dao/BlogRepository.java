package com.ftj.dao;

import com.ftj.pojo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by fengtj on 2021/8/10 0:33
 */
public interface BlogRepository extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {
}
