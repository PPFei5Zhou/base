package com.easy.base.controller;

import com.easy.base.domain.dto.JsonResult;
import com.easy.base.domain.dto.UserDTO;
import com.easy.base.domain.vo.UserVO;
import com.easy.base.service.impl.UserServiceImpl;
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

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public JsonResult login(HttpServletRequest request, String account, String password) {
        HttpSession session = request.getSession();
        JsonResult jsonResult = new JsonResult();
        UserDTO userDTO = new UserDTO(account, password);
        userDTO.setMethodName("login");
        JsonResult result = userService.listObjectFactory(userDTO);
        UserVO userVO = (UserVO)result.getObj();
        UserVO sessionObj = (UserVO)session.getAttribute("User");
        if (Objects.equals(sessionObj, userVO)) {
            jsonResult.setObject(sessionObj);
        } else {
            session.setAttribute("User", userVO);
            jsonResult.setObject(userVO);
        }
        jsonResult.setResult(true);
        return jsonResult;
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
        HttpSession session = request.getSession();
        JsonResult jsonResult = new JsonResult();
        UserVO sessionObj = (UserVO)session.getAttribute("User");
        if (sessionObj != null) {
            jsonResult.setResult(true);
            jsonResult.setObject(sessionObj);
        } else {
            jsonResult.setResult(false);
            session.removeAttribute("User");
        }
        return jsonResult;
    }
}
