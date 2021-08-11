package com.ftj.web.admin;

import com.ftj.pojo.Blog;
import com.ftj.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fengtj on 2021/8/7 16:28
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 2, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, Blog blog, Model model) {
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return "admin/blogs";
    }


    @GetMapping("/blogs/search")
    public String search(@PageableDefault(size = 2, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, Blog blog, Model model) {
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return "admin/blogs :: blogList";
    }
}
