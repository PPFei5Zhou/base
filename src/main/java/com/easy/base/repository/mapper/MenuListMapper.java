package com.easy.base.repository.mapper;

import com.easy.base.domain.dao.MenuItemDAO;
import com.easy.base.domain.dto.dTree.DTreeData;
import com.easy.base.repository.BaseMapper;

import java.util.List;

public interface MenuListMapper extends BaseMapper<MenuItemDAO> {
    List<Integer> getMenuLevel();
    List<MenuItemDAO> selectChildMenu(String id);
    List<DTreeData> getDTreeData(DTreeData model);
}