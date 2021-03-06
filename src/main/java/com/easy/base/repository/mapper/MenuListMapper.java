package com.easy.base.repository.mapper;

import com.easy.base.domain.dao.MenuInfoDAO;
import com.easy.base.domain.dto.dTree.DTreeData;
import com.easy.base.repository.BaseMapper;

import java.util.List;

public interface MenuListMapper extends BaseMapper<MenuInfoDAO> {
    List<Integer> getMenuLevel();
    List<MenuInfoDAO> selectChildMenu(String id);
    List<DTreeData> getDTreeData(DTreeData model);
    List<DTreeData> getDTreeChildrenData(String id);
}