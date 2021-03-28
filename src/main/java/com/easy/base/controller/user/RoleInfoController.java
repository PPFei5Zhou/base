package com.easy.base.controller.user;

import com.easy.base.controller.BaseController;
import com.easy.base.domain.dto.user.RoleInfoDTO;
import com.easy.base.service.impl.user.RoleInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("RoleInfo")
public class RoleInfoController extends BaseController<RoleInfoDTO, RoleInfoService> {
    public RoleInfoController() {
        urlPrefix = "/roleInfo";
    }
}