package com.easy.base.service.impl;

import com.easy.base.domain.dao.BaseDAO;
import com.easy.base.domain.dto.ResultDTO;
import com.easy.base.repository.BaseMapper;
import com.easy.base.service.IBaseService;
import com.easy.base.utils.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    /** 获取当前用户账号 */
    public String getSessionUserAccount() {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }

    @Override
    public ResultDTO<?> insertEntity(T model) {
        try {
            Date now = new Date();
            model.setId(uuidUtil.generateUUID());
            model.setCreateBy(getSessionUserAccount());
            model.setCreateDt(new Timestamp(now.getTime()));
            model.setUpdateBy(getSessionUserAccount());
            model.setUpdateDt(new Timestamp(now.getTime()));
            int i = mapper.insertEntity(model);
            return ResultDTO.CreateResult(i > 0, model.getId());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultDTO.CreateResult(false, e.getMessage());
        }
    }

    @Override
    public ResultDTO<?> updateEntity(T model) {
        try {
            Date now = new Date();
            model.setUpdateBy(getSessionUserAccount());
            model.setUpdateDt(new Timestamp(now.getTime()));
            int i = mapper.updateEntity(model);
            return ResultDTO.CreateResult(i > 0);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultDTO.CreateResult(false, e.getMessage());
        }
    }

    @Override
    public ResultDTO<?> removeEntity(String[] ids) {
        try {
            int i = mapper.removeEntity(ids);
            return ResultDTO.CreateResult(i > 0);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultDTO.CreateResult(false, e.getMessage());
        }
    }

    @Override
    public ResultDTO<?> removeEntity(T model) {
        try {
            List<T> list = mapper.selectEntities(model, 1, Integer.MAX_VALUE);
            if (list == null || list.size() == 0) return ResultDTO.CreateResult(false, "No any data with this condition");
            List<String> idList = list.stream().map(T::getId).distinct().collect(Collectors.toList());
            String[] ids = new String[101];
            int effectiveRow = 0;
            int i = 0;
            for (String id : idList) {
                ids[i] = id;
                if (i % 100 == 0) {
                    effectiveRow += mapper.removeEntity(ids);
                    ids = new String[101];
                    i = 0;
                }
                i++;
            }
            return ResultDTO.CreateResult(effectiveRow > 0, String.format("共删除%d行数据", effectiveRow));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultDTO.CreateResult(false, e.getMessage());
        }
    }

    @Override
    public ResultDTO<List<T>> selectEntities(T model, int page, int limit) {
        try {
            List<T> list = mapper.selectEntities(model, page, limit);
            int count = mapper.countSelect(model);
            return ResultDTO.CreateResult(true, list, count);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultDTO.CreateResult(false, e.getMessage());
        }
    }

    @Override
    public ResultDTO<T> selectEntityByID(String id) {
        try {
            T entity = mapper.selectEntityById(id);
            return ResultDTO.CreateResult(true, entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResultDTO.CreateResult(false, e.getMessage());
        }
    }

    @Override
    public ResultDTO<File> exportToExcel(T model) {
        throw new UnsupportedOperationException("Service未实现此方法");
    }
}
