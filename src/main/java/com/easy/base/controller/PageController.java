package com.easy.base.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
@Api(tags = "根目录页面")
public class PageController {
    @ApiOperation(value = "登录页")
    @GetMapping("Login")
    public String login() {
        return  "login";
    }

    @ApiOperation(value = "首页")
    @GetMapping("Index")
    public String index() {
        return "index";
    }

    @ApiOperation(value = "登录错误页")
    @GetMapping("/LoginError")
    public void loginError(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        AuthenticationException exception = (AuthenticationException)request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try {
            response.getWriter().write(exception.getMessage());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "无效页")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @GetMapping("/Invalid")
    public String invalid() {
        return "invalid";
    }
}
