package com.easy.base.controller.user;

import com.easy.base.controller.BaseController;

import com.easy.base.domain.dto.user.UserDTO;
import com.easy.base.service.user.IUserServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/User")
@Api(tags = "用户信息")
public class UserController extends BaseController<UserDTO, IUserServer> {
    @Resource
    private SessionRegistry sessionRegistry;

    public UserController() {
        urlPrefix = "User";
    }

    @ApiOperation(value = "踢出用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userAccount", value = "用户账号", dataTypeClass = String.class, paramType = "query", example = "admin")
    })
    @PreAuthorize("hasRole('ROLE_ADMIN1')")
    @PostMapping("/KickOutUser")
    public ResponseEntity<String> kickOutUser(String userAccount) {
        int count = 0;
        List<Object> users = sessionRegistry.getAllPrincipals();
        for (Object principal : users) {
            if (principal instanceof UserDetails) {
                String principalName = ((UserDetails) principal).getUsername();
                if (principalName.equals(userAccount)) {
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
        return ResponseEntity.ok("操作成功，清理session共" + count + "个");
    }

    @ApiOperation(value = "获取当前登录的用户")
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value = "/GetSessionUser")
    public ResponseEntity<?> getSessionUser(@ApiIgnore Principal principal) {
        return responseEntity(service.selectEntityByID(principal.getName()));
    }
}
