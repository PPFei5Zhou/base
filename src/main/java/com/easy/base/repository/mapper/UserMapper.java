package com.easy.base.repository.mapper;

import com.easy.base.domain.dao.user.RoleInfoDAO;
import com.easy.base.domain.dto.user.UserDTO;
import com.easy.base.repository.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<UserDTO> {
    RoleInfoDAO selectRoleInfoByRoleCode(@Param("roleCode") String roleCode);
    List<UserDTO> selectUserRoleByUserAccount(@Param("userAccount") String userAccount);
}