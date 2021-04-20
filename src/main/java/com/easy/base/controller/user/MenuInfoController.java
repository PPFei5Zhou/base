package com.easy.base.controller.user;

import com.easy.base.controller.BaseController;
import com.easy.base.domain.dto.dTree.DTreeDTO;
import com.easy.base.domain.dto.dTree.DTreeData;
import com.easy.base.domain.dto.user.MenuInfoDTO;
import com.easy.base.service.user.IMenuListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("UserMenu")
@Api(tags = "菜单信息")
public class MenuInfoController extends BaseController<MenuInfoDTO, IMenuListService> {

    public MenuInfoController() {
        urlPrefix = "userMenu";
    }

    @ApiOperation(value = "获取菜单层级")
    @GetMapping("GetMenuLevel")
    public ResponseEntity<?> getMenuLevel() {
        return responseEntity(service.getMenuLevel());
    }

    @ApiOperation(value = "上移菜单")
    @PostMapping("RiseMenuSort")
    public ResponseEntity<?> riseMenuSort(String id) {
        return responseEntity(service.riseMenuSort(id));
    }

    @ApiOperation(value = "下移菜单")
    @PostMapping("DropMenuSort")
    public ResponseEntity<?> dropMenuSort(String id) {
        return responseEntity(service.dropMenuSort(id));
    }

    @ApiOperation(value = "获取DTree数据设置")
    @GetMapping("GetDTree")
    public ResponseEntity<DTreeDTO> getDTree(DTreeData model) {
        return ResponseEntity.ok(service.getDTree(model));
    }
}
