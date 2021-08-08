package com.easy.base.controller;

import com.easy.base.domain.dao.BaseDAO;
import com.easy.base.domain.dto.ResultDTO;
import com.easy.base.domain.dto.LayuiTable;
import com.easy.base.service.IBaseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.security.Principal;

public class BaseController<T extends BaseDAO, S extends IBaseService<T>> {
    @Autowired
    @SuppressWarnings("all")
    public S service;

    public String urlPrefix;

    @Resource
    public HttpServletRequest request;

    @Resource
    public HttpServletResponse response;

    @Resource
    public HttpSession session;

    /** 获取当前用户账号 */
    public String getSessionUserAccount() {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }

    public ResponseEntity<?> responseEntity(ResultDTO<?> result) {
        if (result.isResult()) {
            if (result.getObj() != null)
                return ResponseEntity.ok(result.getObj());
            else
                return ResponseEntity.ok(result.getMessage());
        } else {
            return new ResponseEntity<>(result.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "首页")
    @GetMapping("/Index")
    public ModelAndView index() {
        return new ModelAndView(urlPrefix + "/index");
    }

    @ApiOperation(value = "编辑页")
    @GetMapping("/Edit")
    public ModelAndView edit(String id) {
        return new ModelAndView(urlPrefix + "/edit");
    }

    @ApiOperation(value = "明细页")
    @GetMapping("/Detail")
    public ModelAndView detail(String id) {
        return new ModelAndView(urlPrefix + "/detail");
    }

    @ApiOperation(value = "新增实体")
    @PostMapping("InsertEntity")
    public ResponseEntity<?> insertEntity(T model) {
        return responseEntity(service.insertEntity(model));
    }

    @ApiOperation(value = "修改实体")
    @PutMapping("UpdateEntity")
    public ResponseEntity<?> updateEntity(T model) {
        return responseEntity(service.updateEntity(model));
    }

    @ApiOperation(value = "删除多个实体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "页码", dataTypeClass = String[].class, paramType = "query")
    })
    @DeleteMapping("RemoveEntity")
    public ResponseEntity<?> removeEntity(@RequestParam(value = "ids[]") String[] ids) {
        return responseEntity(service.removeEntity(ids));
    }

    @ApiOperation(value = "按条件删除实体")
    @DeleteMapping("RemoveEntityByCondition")
    public ResponseEntity<?> responseEntity(T model) {
        return responseEntity(service.removeEntity(model));
    }

    @ApiOperation(value = "分页查询实体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", dataTypeClass = Integer.class, paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页数量", dataTypeClass = Integer.class, paramType = "query")
    })
    @GetMapping("SelectEntities")
    public ResponseEntity<?> selectEntities(T model, int page, int limit) {
        return responseEntity(service.selectEntities(model, page, limit));
    }

    @ApiOperation(value = "分页查询实体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", dataTypeClass = Integer.class, paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页数量", dataTypeClass = Integer.class, paramType = "query")
    })
    @GetMapping("EntitiesLayuiTable")
    public ResponseEntity<LayuiTable> entitiesLayuiTable(T model, int page, int limit) {
        ResultDTO<?> result = service.selectEntities(model, page, limit);
        int code = result.isResult() ? 0 : 1;
        return ResponseEntity.ok(new LayuiTable(code, result.getMessage(), result.getCount(), result.getObj()));
    }

    @ApiOperation(value = "查询指定的实体")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据ID", dataTypeClass = String.class, paramType = "query")
    })
    @GetMapping("SelectEntityByID")
    public ResponseEntity<?> selectEntityByID(String id) {
        return responseEntity(service.selectEntityByID(id));
    }
}
