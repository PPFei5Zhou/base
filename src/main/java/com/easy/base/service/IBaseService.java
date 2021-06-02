package com.easy.base.service;

import com.easy.base.domain.dto.ResultDTO;

import java.io.File;
import java.util.List;

public interface IBaseService<T> {
    ResultDTO<?> insertEntity(T model);
    ResultDTO<?> updateEntity(T model);
    ResultDTO<?> removeEntity(String[] ids);
    ResultDTO<?> removeEntity(T model);
    ResultDTO<List<T>> selectEntities(T model, int page, int limit);
    ResultDTO<T> selectEntityByID(String id);
    ResultDTO<File> exportToExcel(T model);
}
