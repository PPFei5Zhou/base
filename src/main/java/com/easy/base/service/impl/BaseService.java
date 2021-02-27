package com.easy.base.service.impl;

import com.easy.base.domain.dao.BaseDAO;
import com.easy.base.domain.dto.JsonResult;
import com.easy.base.repository.BaseMapper;
import com.easy.base.service.IBaseService;
import com.easy.base.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Slf4j
public class BaseService<T extends BaseDAO, M extends BaseMapper<T>> implements IBaseService<T> {
    @Autowired
    @SuppressWarnings("all")
    public M mapper;

    @Resource
    public HttpServletRequest request;

    @Resource
    public HttpSession session;

    @Resource
    public UUIDUtil uuidUtil;

    @Override
    public JsonResult<?> insertEntity(T model) {
        try {
            Principal principal = request.getUserPrincipal();
            Date now = new Date();
            model.setId(uuidUtil.generateUUID());
            model.setCreateBy(principal.getName());
            model.setCreateDt(new Timestamp(now.getTime()));
            int i = mapper.insertEntity(model);
            return JsonResult.CreateResult(i > 0, model.getId());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonResult.CreateResult(false, e.getMessage());
        }
    }

    @Override
    public JsonResult<?> updateEntity(T model) {
        try {
            Principal principal = request.getUserPrincipal();
            Date now = new Date();
            model.setUpdateBy(principal.getName());
            model.setUpdateDt(new Timestamp(now.getTime()));
            int i = mapper.updateEntity(model);
            return JsonResult.CreateResult(i > 0);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonResult.CreateResult(false, e.getMessage());
        }
    }

    @Override
    public JsonResult<?> removeEntity(String[] ids) {
        try {
            int i = mapper.removeEntity(ids);
            return JsonResult.CreateResult(i > 0);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonResult.CreateResult(false, e.getMessage());
        }
    }

    @Override
    public JsonResult<List<T>> selectEntities(T model, int page, int limit) {
        try {
            List<T> list = mapper.selectEntities(model, page, limit);
            int count = mapper.countSelect(model);
            return JsonResult.CreateResult(true, list, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonResult.CreateResult(false, e.getMessage());
        }
    }

    @Override
    public JsonResult<T> selectEntityByID(String id) {
        try {
            T entity = mapper.selectEntityById(id);
            return JsonResult.CreateResult(true, entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return JsonResult.CreateResult(false, e.getMessage());
        }
    }
}
