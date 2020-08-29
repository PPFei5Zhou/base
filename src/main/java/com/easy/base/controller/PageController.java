package com.easy.base.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Scope("session")
@Controller
@RequestMapping("/")
public class PageController {
    @RequestMapping("Login")
    public String login() {
        return  "/html/login.html";
    }

    @RequestMapping("Index")
    public String index() {
        return "/html/index.html";
    }
}
