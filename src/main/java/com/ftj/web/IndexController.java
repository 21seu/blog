package com.ftj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by fengtj on 2021/7/30 21:03
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {

        System.out.println("--------index--------");
        return "index";
    }
}
