package com.easy.base.domain.dao.user;

import com.easy.base.domain.dao.BaseDAO;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class UserInfoDAO extends BaseDAO {
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户账号")
    private String userAccount;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("权限列表")
    private List<UserRoleDAO> userRoles;
}