package com.ftj.service.impl;

import com.ftj.NotFoundException;
import com.ftj.dao.TagRepository;
import com.ftj.pojo.Tag;
import com.ftj.pojo.Type;
import com.ftj.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by fengtj on 2021/8/9 23:18
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTag(Long id) {
        return tagRepository.getOne(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public Tag updateType(Long id, Tag tag) {
        Tag t = tagRepository.findById(id).orElse(null);
        if (t == null) throw new NotFoundException("不存在该类型");
        BeanUtils.copyProperties(tag, t);
        return tagRepository.save(t);
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public Page<Tag> listTags(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }
}
