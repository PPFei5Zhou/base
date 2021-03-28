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
public class RoleInfoDAO extends BaseDAO {
    private String roleCode;
    private String roleName;
    private int roleSort;
}
