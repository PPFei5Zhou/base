package com.easy.base.domain.dto.user;

import com.easy.base.domain.dao.user.UserInfoDAO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户信息")
public class UserDTO extends UserInfoDAO {
    @ApiModelProperty("页码")
    private int page;

    @ApiModelProperty("每页数量")
    private int pageSize;

    @ApiModelProperty("方法名称")
    private String methodName;
}
