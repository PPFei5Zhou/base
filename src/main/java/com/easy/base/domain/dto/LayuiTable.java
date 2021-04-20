package com.easy.base.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ApiModel("Layui table 响应数据模型")
public class LayuiTable {
    @ApiModelProperty("接口状态")
    private int code;

    @ApiModelProperty("提示文本")
    private String msg;

    @ApiModelProperty("数据长度")
    private int count;

    @ApiModelProperty("数据列表")
    private Object data;
}
