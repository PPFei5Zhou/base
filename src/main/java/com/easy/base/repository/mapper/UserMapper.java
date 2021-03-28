package com.easy.base.repository.mapper;

import com.easy.base.domain.dao.user.RoleInfoDAO;
import com.easy.base.domain.dao.user.UserRoleDAO;
import com.easy.base.repository.BaseMapper;
import com.easy.base.domain.dao.user.UserInfoDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<UserInfoDAO> {
    RoleInfoDAO selectRoleInfoByRoleCode(@Param("roleCode") String roleCode);
    List<UserRoleDAO> selectUserRoleByUserAccount(@Param("userAccount") String userAccount);
}