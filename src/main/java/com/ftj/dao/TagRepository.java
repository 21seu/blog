package com.ftj.dao;

import com.ftj.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fengtj on 2021/8/9 23:19
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findByName(String name);
}
