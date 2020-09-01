package com.easy.base.controller;

import com.easy.base.domain.dto.JsonResult;
import com.easy.base.domain.dto.UserDTO;
import com.easy.base.domain.vo.UserVO;
import com.easy.base.service.impl.UserServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/User")
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/Logout", method = RequestMethod.POST)
    public JsonResult logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        JsonResult jsonResult = new JsonResult();
        UserVO sessionObj = (UserVO)session.getAttribute("User");
        if (sessionObj != null) {
            session.removeAttribute("User");
        }
        jsonResult.setResult(true);
        return jsonResult;
    }

    @RequestMapping(value = "/GetSessionUser", method = RequestMethod.GET)
    public JsonResult getSessionUser(HttpServletRequest request) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setResult(true);
        jsonResult.setObj(SecurityContextHolder.getContext().getAuthentication().getName());
        return jsonResult;
    }
}
