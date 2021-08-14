package com.ftj.dao;

import com.ftj.pojo.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by fengtj on 2021/8/7 17:04
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    /**
     * 根据分类名称查询分类
     * @param name
     * @return
     */
    Type findByName(String name);

    @Query("select t from Type t ")
    List<Type> findTop(Pageable pageable);
}
