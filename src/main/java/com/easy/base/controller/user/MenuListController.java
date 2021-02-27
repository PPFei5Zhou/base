package com.easy.base.controller.user;

import com.easy.base.controller.BaseController;
import com.easy.base.domain.dao.MenuItemDAO;
import com.easy.base.domain.dto.JsonResult;
import com.easy.base.domain.dto.dTree.DTreeDTO;
import com.easy.base.domain.dto.dTree.DTreeData;
import com.easy.base.service.user.IMenuListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("UserMenu")
public class MenuListController extends BaseController<MenuItemDAO, IMenuListService> {

    public MenuListController() {
        urlPrefix = "userMenu";
    }

    @GetMapping("GetMenuLevel")
    public JsonResult<?> getMenuLevel() {
        return service.getMenuLevel();
    }

    @PostMapping("RiseMenuSort")
    public JsonResult<?> riseMenuSort(String id) {
        return service.riseMenuSort(id);
    }

    @PostMapping("DropMenuSort")
    public JsonResult<?> dropMenuSort(String id) {
        return service.dropMenuSort(id);
    }

    @GetMapping("GetDTree")
    public DTreeDTO getDTree(DTreeData model) {
        return service.getDTree(model);
    }
}
