package com.easy.base.repository.mapper;

import com.easy.base.domain.dto.dTree.DTreeData;
import com.easy.base.domain.dto.user.MenuInfoDTO;
import com.easy.base.repository.BaseMapper;

import java.util.List;

public interface MenuListMapper extends BaseMapper<MenuInfoDTO> {
    List<Integer> getMenuLevel();
    List<MenuInfoDTO> selectChildMenu(String id);
    List<DTreeData> getDTreeData(DTreeData model);
    List<DTreeData> getDTreeChildrenData(String id);
}