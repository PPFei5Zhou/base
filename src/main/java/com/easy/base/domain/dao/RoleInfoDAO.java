package com.easy.base.domain.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class RoleInfoDAO extends BaseDAO {
    private int id;
    private String roleName;
}
