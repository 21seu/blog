package com.ftj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by fengtj on 2021/7/30 21:03
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        int i = 9 / 0;
        return "index";
    }
}
