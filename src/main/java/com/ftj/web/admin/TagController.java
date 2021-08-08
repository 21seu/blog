package com.ftj.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fengtj on 2021/8/7 19:07
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    @RequestMapping("/tags")
    public String tagPage(){
        return "admin/tags";
    }
}
