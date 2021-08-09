package com.ftj.service;

import com.ftj.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by fengtj on 2021/8/7 19:04
 */
public interface TagService {

    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Tag updateType(Long id, Tag tag);

    void deleteTag(Long id);

    Page<Tag> listTags(Pageable pageable);
}
