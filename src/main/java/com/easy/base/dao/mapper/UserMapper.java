package com.easy.base.dao.mapper;

import com.easy.base.dao.BaseMapper;
import com.easy.base.domain.dao.UserInfoDAO;
import com.easy.base.domain.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper {
    @Override
    int saveObject();

    @Override
    int updateObject();

    @Override
    int removeObject();

    List<UserInfoDAO> listUser(UserDTO dto);
}