package com.easy.base.domain.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class RoleInfoDAO extends BaseDAO {
    private String id;
    private String roleCode;
    private String roleName;
}
