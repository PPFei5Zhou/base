package com.easy.base.service.user;

import com.easy.base.domain.dto.user.RoleInfoDTO;
import com.easy.base.service.IBaseService;

public interface IRoleInfoService extends IBaseService<RoleInfoDTO> {
    /** Role Hierarchy Chain */
    String roleHierarchyChain();
}
