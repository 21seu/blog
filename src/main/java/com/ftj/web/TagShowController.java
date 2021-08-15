package com.ftj.web;

import com.ftj.pojo.Tag;
import com.ftj.pojo.Type;
import com.ftj.service.BlogService;
import com.ftj.service.TagService;
import com.ftj.service.TypeService;
import com.ftj.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by fengtj on 2021/8/15 17:32
 */
@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/tag/{id}")
    public String tags(@PageableDefault(sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                       Model model,
                       @PathVariable Long id) {

        List<Tag> tags = tagService.listTagTop(10000);
        if (id == -1) id = tags.get(0).getId();
        model.addAttribute("tags", tags);
        model.addAttribute("page", blogService.listBlog(id, pageable));
        model.addAttribute("activeTagId", id);
        return "tags";
    }
}
