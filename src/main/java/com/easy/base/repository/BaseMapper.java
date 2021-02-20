package com.easy.base.repository;

import com.easy.base.domain.dao.BaseDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<T extends BaseDAO> {
    int insertEntity(T model);
    int updateEntity(T model);
    int removeEntity(@Param("ids") String[] ids);
    int countSelect(T model);
    List<T> selectEntities(@Param("model") T model, @Param("page") int page, @Param("limit") int limit);
    T selectEntityById(String id);
}
