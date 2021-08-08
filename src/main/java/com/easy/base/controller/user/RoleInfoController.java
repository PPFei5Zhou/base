package com.easy.base.controller.user;

import com.easy.base.controller.BaseController;
import com.easy.base.domain.dto.user.RoleInfoDTO;
import com.easy.base.service.impl.user.RoleInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("RoleInfo")
@Api(tags = "权限信息")
public class RoleInfoController extends BaseController<RoleInfoDTO, RoleInfoService> {
    public RoleInfoController() {
        urlPrefix = "/roleInfo";
    }

    @ApiOperation(value = "权限信息")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("PrincipalInfo")
    public ResponseEntity<?> principalInfo() {
        Principal principal = request.getUserPrincipal();
        return ResponseEntity.ok(principal);
    }

    @ApiOperation(value = "权限清单")
    @RequestMapping("AuthenticationInfo")
    public ResponseEntity<?> authenticationInfo() {
        Principal principal = request.getUserPrincipal();
        Authentication authentication = (Authentication) principal;
        return ResponseEntity.ok(authentication.getAuthorities());
    }
}