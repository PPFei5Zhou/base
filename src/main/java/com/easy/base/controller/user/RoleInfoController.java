package com.easy.base.controller.user;

import com.easy.base.controller.BaseController;
import com.easy.base.domain.dto.user.RoleInfoDTO;
import com.easy.base.service.impl.user.RoleInfoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("RoleInfo")
@Api(tags = "权限信息")
public class RoleInfoController extends BaseController<RoleInfoDTO, RoleInfoService> {
    public RoleInfoController() {
        urlPrefix = "/roleInfo";
    }
}