package com.easy.base.controller.user;

import com.easy.base.controller.BaseController;
import com.easy.base.domain.dto.dTree.DTreeDTO;
import com.easy.base.domain.dto.dTree.DTreeData;
import com.easy.base.domain.dto.user.MenuInfoDTO;
import com.easy.base.service.user.IMenuListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("UserMenu")
public class MenuInfoController extends BaseController<MenuInfoDTO, IMenuListService> {

    public MenuInfoController() {
        urlPrefix = "userMenu";
    }

    @GetMapping("GetMenuLevel")
    public ResponseEntity<?> getMenuLevel() {
        return responseEntity(service.getMenuLevel());
    }

    @PostMapping("RiseMenuSort")
    public ResponseEntity<?> riseMenuSort(String id) {
        return responseEntity(service.riseMenuSort(id));
    }

    @PostMapping("DropMenuSort")
    public ResponseEntity<?> dropMenuSort(String id) {
        return responseEntity(service.dropMenuSort(id));
    }

    @GetMapping("GetDTree")
    public ResponseEntity<DTreeDTO> getDTree(DTreeData model) {
        return ResponseEntity.ok(service.getDTree(model));
    }
}
