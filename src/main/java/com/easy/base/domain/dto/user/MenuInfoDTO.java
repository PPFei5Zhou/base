package com.easy.base.domain.dto.user;

import com.easy.base.domain.dao.user.MenuInfoDAO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@ApiModel(value = "菜单信息")
public class MenuInfoDTO extends MenuInfoDAO { }
