package com.easy.base.domain.dao.user;

import com.easy.base.domain.dao.BaseDAO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class UserRoleDAO extends BaseDAO {
    private String userAccount;
    private String roleCode;
    private RoleInfoDAO roleInfo;
}
