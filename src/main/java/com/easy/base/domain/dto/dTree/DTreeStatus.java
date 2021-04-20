package com.easy.base.domain.dto.dTree;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "DTree 数据的返回状态")
public class DTreeStatus {
    @ApiModelProperty(value = "状态码")
    private int code;

    @ApiModelProperty(value = "信息标识")
    private String message;
}
