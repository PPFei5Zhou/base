package com.easy.base.domain.dto.user;

import com.easy.base.domain.dao.user.RoleInfoDAO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@ApiModel(value = "权限信息")
public class RoleInfoDTO extends RoleInfoDAO { }
