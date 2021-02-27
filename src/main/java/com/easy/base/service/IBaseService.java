package com.easy.base.service;

import com.easy.base.domain.dto.JsonResult;

import java.util.List;

public interface IBaseService<T> {
    JsonResult<?> insertEntity(T model);
    JsonResult<?> updateEntity(T model);
    JsonResult<?> removeEntity(String[] ids);
    JsonResult<List<T>> selectEntities(T model, int page, int limit);
    JsonResult<T> selectEntityByID(String id);
}
