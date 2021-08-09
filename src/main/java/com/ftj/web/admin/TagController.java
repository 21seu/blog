package com.ftj.web.admin;

import com.ftj.pojo.Tag;
import com.ftj.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fengtj on 2021/8/7 19:07
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TagService tagService;

    @RequestMapping("/tags")
    public String tagPage(@PageableDefault(sort = {"id"}) Pageable pageable, Model model) {
        Page<Tag> page = tagService.listTags(pageable);
        model.addAttribute("page", page);
        LOGGER.info("page {}", page);
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }
}
