package com.easy.base.service.impl.user;

import com.easy.base.domain.dto.user.RoleInfoDTO;
import com.easy.base.repository.mapper.RoleInfoMapper;
import com.easy.base.service.impl.BaseService;
import com.easy.base.service.user.IRoleInfoService;
import org.springframework.stereotype.Service;

@Service
public class RoleInfoService extends BaseService<RoleInfoDTO, RoleInfoMapper> implements IRoleInfoService { }