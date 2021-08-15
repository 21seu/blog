package com.ftj.web;

import com.ftj.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by fengtj on 2021/8/15 18:49
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;


    @GetMapping("/archives")
    public String archives(Model model) {
        model.addAttribute("blogCount", blogService.countBlog());
        model.addAttribute("archiveMap", blogService.archiveBlog());
        return "archives";
    }
}
