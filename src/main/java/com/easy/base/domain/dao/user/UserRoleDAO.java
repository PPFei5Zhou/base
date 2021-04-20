package com.easy.base.domain.dao.user;

import com.easy.base.domain.dao.BaseDAO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
@ApiModel(value = "用户权限")
public class UserRoleDAO extends BaseDAO {
    @ApiModelProperty("账号")
    private String userAccount;
    @ApiModelProperty("权限")
    private String roleCode;
    @ApiModelProperty("权限信息")
    private RoleInfoDAO roleInfo;
}
