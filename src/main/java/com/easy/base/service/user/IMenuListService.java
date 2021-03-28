package com.easy.base.service.user;

import com.easy.base.domain.dao.user.MenuInfoDAO;
import com.easy.base.domain.dto.JsonResult;
import com.easy.base.domain.dto.dTree.DTreeDTO;
import com.easy.base.domain.dto.dTree.DTreeData;
import com.easy.base.service.IBaseService;

public interface IMenuListService extends IBaseService<MenuInfoDAO> {
    JsonResult<?> getMenuLevel();
    /** 菜单上移 */
    JsonResult<?> riseMenuSort(String id);
    /** 菜单下移 */
    JsonResult<?> dropMenuSort(String id);
    /** DTree树形组件数据源 */
    DTreeDTO getDTree(DTreeData model);
}
