package com.easy.base.service;

import com.easy.base.domain.dto.BaseDTO;
import com.easy.base.domain.dto.JsonResult;

public interface BaseService {
    JsonResult saveObject(BaseDTO dto);
    JsonResult updateObject(BaseDTO dto);
    JsonResult removeObject(BaseDTO dto);
    JsonResult getSingleObject(BaseDTO dto);
    JsonResult listObjectFactory(BaseDTO dto);
}
