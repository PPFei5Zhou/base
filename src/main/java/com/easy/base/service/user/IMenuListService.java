package com.easy.base.service.user;

import com.easy.base.domain.dto.ResultDTO;
import com.easy.base.domain.dto.dTree.DTreeDTO;
import com.easy.base.domain.dto.dTree.DTreeData;
import com.easy.base.domain.dto.user.MenuInfoDTO;
import com.easy.base.service.IBaseService;

public interface IMenuListService extends IBaseService<MenuInfoDTO> {
    ResultDTO<?> getMenuLevel();
    /** 菜单上移 */
    ResultDTO<?> riseMenuSort(String id);
    /** 菜单下移 */
    ResultDTO<?> dropMenuSort(String id);
    /** DTree树形组件数据源 */
    DTreeDTO getDTree(DTreeData model);
}
