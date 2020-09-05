package com.easy.base.controller;

import com.easy.base.domain.dto.JsonResult;
import com.easy.base.domain.vo.UserVO;
import com.easy.base.service.impl.UserServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    private UserServiceImpl userService;
    private SessionRegistry sessionRegistry;

    public UserController(UserServiceImpl userService, SessionRegistry sessionRegistry) {
        this.userService = userService;
        this.sessionRegistry = sessionRegistry;
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

    @PreAuthorize("hasRole('ROLE_ADMIN1')")
    @RequestMapping("/KickOutUser")
    public JsonResult kickOutUser(String userName) {
        JsonResult jsonResult = new JsonResult();
        int count = 0;
        List<Object> users = sessionRegistry.getAllPrincipals();
        for (Object principal : users) {
            if (principal instanceof String) {
                String principalName = (String) principal;
                if (principalName.equals(userName)) {
                    List<SessionInformation> allSessions = sessionRegistry.getAllSessions(principal, false);
                    if (null != allSessions && allSessions.size() > 0) {
                        for (SessionInformation sessionInformation : allSessions) {
                            sessionInformation.expireNow();
                            count++;
                        }
                    }
                }
            }
        }
        jsonResult.setResult(true);
        jsonResult.setMessage("操作成功，清理session共" + count + "个");
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
