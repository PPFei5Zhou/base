package com.easy.base.service;

import com.easy.base.domain.dto.ResultDTO;

import java.util.List;

public interface IBaseService<T> {
    ResultDTO<?> insertEntity(T model);
    ResultDTO<?> updateEntity(T model);
    ResultDTO<?> removeEntity(String[] ids);
    ResultDTO<List<T>> selectEntities(T model, int page, int limit);
    ResultDTO<T> selectEntityByID(String id);
}
