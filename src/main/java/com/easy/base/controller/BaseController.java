package com.easy.base.controller;

import com.easy.base.domain.dao.BaseDAO;
import com.easy.base.domain.dto.JsonResult;
import com.easy.base.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public JsonResult<?> insertEntity(T model) {
        return service.insertEntity(model);
    }

    @PostMapping("UpdateEntity")
    public JsonResult<?> updateEntity(T model) {
        return service.updateEntity(model);
    }

    @PostMapping("RemoveEntity")
    public JsonResult<?> removeEntity(@RequestParam(value = "ids[]") String[] ids) {
        return service.removeEntity(ids);
    }

    @GetMapping("SelectEntities")
    public JsonResult<?> selectEntities(T model, int page, int limit) {
        return service.selectEntities(model, page, limit);
    }

    @GetMapping("SelectEntityByID")
    public JsonResult<?> selectEntityByID(String id) {
        return service.selectEntityByID(id);
    }
}
