package com.easy.base.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class PageController {
    @RequestMapping("Login")
    public String login() {
        return  "login";
    }

    @RequestMapping("Index")
    public String index() {
        return "index";
    }

    @RequestMapping("/LoginError")
    public void loginError(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        AuthenticationException exception = (AuthenticationException)request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try {
            response.getWriter().write(exception.getMessage());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @RequestMapping("/Invalid")
    public String invalid() {
        return "invalid";
    }
}
