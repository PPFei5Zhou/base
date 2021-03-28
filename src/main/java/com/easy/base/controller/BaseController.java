package com.easy.base.controller;

import com.easy.base.domain.dao.BaseDAO;
import com.easy.base.domain.dto.ResultDTO;
import com.easy.base.domain.dto.LayuiTable;
import com.easy.base.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

public class BaseController<T extends BaseDAO, S extends IBaseService<T>> {
    @Autowired
    @SuppressWarnings("all")
    public S service;

    public String urlPrefix;

    @Resource
    public HttpServletRequest request;

    /** 获取当前用户账号 */
    public String getSessionUserAccount() {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }

    public ResponseEntity<?> responseEntity(ResultDTO<?> result) {
        if (result.isResult()) {
            return ResponseEntity.ok(result.getObj());
        } else {
            return new ResponseEntity<>(result.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Index")
    public ModelAndView index() {
        return new ModelAndView(urlPrefix + "/index");
    }

    @GetMapping("/Edit")
    public ModelAndView edit(String id) {
        return new ModelAndView(urlPrefix + "/edit");
    }

    @GetMapping("/Detail")
    public ModelAndView detail(String id) {
        return new ModelAndView(urlPrefix + "/detail");
    }

    @PostMapping("InsertEntity")
    public ResponseEntity<?> insertEntity(T model) {
        return responseEntity(service.insertEntity(model));
    }

    @PutMapping("UpdateEntity")
    public ResponseEntity<?> updateEntity(T model) {
        return responseEntity(service.updateEntity(model));
    }

    @DeleteMapping("RemoveEntity")
    public ResponseEntity<?> removeEntity(@RequestParam(value = "ids[]") String[] ids) {
        return responseEntity(service.removeEntity(ids));
    }

    @GetMapping("SelectEntities")
    public ResponseEntity<?> selectEntities(T model, int page, int limit) {
        return responseEntity(service.selectEntities(model, page, limit));
    }

    @GetMapping("EntitiesLayuiTable")
    public ResponseEntity<LayuiTable> entitiesLayuiTable(T model, int page, int limit) {
        ResultDTO<?> result = service.selectEntities(model, page, limit);
        int code = result.isResult() ? 0 : 1;
        return ResponseEntity.ok(new LayuiTable(code, result.getMessage(), result.getCount(), result.getObj()));
    }

    @GetMapping("SelectEntityByID")
    public ResponseEntity<?> selectEntityByID(String id) {
        return responseEntity(service.selectEntityByID(id));
    }
}
