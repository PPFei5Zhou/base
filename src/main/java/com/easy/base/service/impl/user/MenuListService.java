package com.easy.base.service.impl.user;

import com.easy.base.domain.dto.ResultDTO;
import com.easy.base.domain.dto.dTree.DTreeDTO;
import com.easy.base.domain.dto.dTree.DTreeData;
import com.easy.base.domain.dto.dTree.DTreeStatus;
import com.easy.base.domain.dto.user.MenuInfoDTO;
import com.easy.base.repository.mapper.MenuListMapper;
import com.easy.base.service.impl.BaseService;
import com.easy.base.service.user.IMenuListService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MenuListService extends BaseService<MenuInfoDTO, MenuListMapper> implements IMenuListService {
    @Override
    public ResultDTO<?> insertEntity(MenuInfoDTO model) {
        String parentId = model.getParentId();
        if (StringUtils.isBlank(parentId)) {
            MenuInfoDTO model1 = new MenuInfoDTO();
            model1.setMenuLevel(0);
            List<MenuInfoDTO> list = mapper.selectEntities(model1, 1, Integer.MAX_VALUE);
            model.setMenuLevel(0);
            model.setMenuSort(list.size() + 1);
        } else {
            MenuInfoDTO parentMenu = mapper.selectEntityById(parentId);
            if (parentMenu != null) {
                model.setMenuLevel(parentMenu.getMenuLevel() + 1);
                model.setMenuSort(parentMenu.getChildMenu().size() + 1);
            }
        }
        return super.insertEntity(model);
    }

    @Override
    public ResultDTO<?> getMenuLevel() {
        try {
            List<Integer> menuLevel = mapper.getMenuLevel();
            return ResultDTO.CreateResult(true, menuLevel);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultDTO.CreateResult(false, e.getMessage());
        }
    }

    @Override
    public ResultDTO<?> riseMenuSort(String id) {
        try {
            MenuInfoDTO menuItem = mapper.selectEntityById(id);
            if (menuItem.getMenuSort() > 0) {
                menuItem.setMenuSort(menuItem.getMenuSort() - 1);
            }
            return updateEntity(menuItem);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultDTO.CreateResult(true, e.getMessage());
        }
    }

    @Override
    public ResultDTO<?> dropMenuSort(String id) {
        try {
            MenuInfoDTO menuItem = mapper.selectEntityById(id);
            menuItem.setMenuSort(menuItem.getMenuSort() + 1);
            return updateEntity(menuItem);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultDTO.CreateResult(true, e.getMessage());
        }
    }

    @Override
    public DTreeDTO getDTree(DTreeData model) {
        DTreeDTO dTreeDTO = new DTreeDTO();
        try {
            List<DTreeData> list = mapper.getDTreeData(model);

            if (list != null && list.size() > 0) {
                dTreeDTO.setStatus(new DTreeStatus(200, "请求成功!"));
                dTreeDTO.setData(list);
            } else {
                dTreeDTO.setStatus(new DTreeStatus(501, "请求成功, 无数据"));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            dTreeDTO.setStatus(new DTreeStatus(505, e.getMessage()));
        }
        return dTreeDTO;
    }
}
