package com.ftj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by fengtj on 2021/8/15 22:30
 */
@Controller
public class AboutShowController {

    @GetMapping("/about")
    public String about() {

        return "about";
    }
}
