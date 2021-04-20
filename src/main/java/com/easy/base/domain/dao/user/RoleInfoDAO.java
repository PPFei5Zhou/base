package com.easy.base.domain.dao.user;

import com.easy.base.domain.dao.BaseDAO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class RoleInfoDAO extends BaseDAO {
    @ApiModelProperty("权限")
    private String roleCode;
    @ApiModelProperty("权限名称")
    private String roleName;
    @ApiModelProperty("顺序")
    private int roleSort;
}
