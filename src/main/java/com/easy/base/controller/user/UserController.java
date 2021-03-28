package com.easy.base.controller.user;

import com.easy.base.controller.BaseController;
import com.easy.base.domain.dao.user.UserInfoDAO;
import com.easy.base.domain.dto.JsonResult;

import com.easy.base.service.user.IUserServer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController extends BaseController<UserInfoDAO, IUserServer> {
    @Resource
    private SessionRegistry sessionRegistry;

    public UserController() {
        urlPrefix = "User";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN1')")
    @RequestMapping("/KickOutUser")
    public JsonResult<String> kickOutUser(String userName) {
        int count = 0;
        List<Object> users = sessionRegistry.getAllPrincipals();
        for (Object principal : users) {
            if (principal instanceof UserDetails) {
                String principalName = ((UserDetails) principal).getUsername();
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
        return JsonResult.CreateResult(true, "操作成功，清理session共" + count + "个");
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/GetSessionUser", method = RequestMethod.GET)
    public JsonResult<UserInfoDAO> getSessionUser(Principal principal) {
        return service.selectEntityByID(principal.getName());
    }
}
