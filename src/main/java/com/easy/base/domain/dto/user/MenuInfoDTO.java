package com.easy.base.domain.dto.user;

import com.easy.base.domain.dao.user.MenuInfoDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class MenuInfoDTO extends MenuInfoDAO { }
