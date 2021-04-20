package com.easy.base.domain.dto.dTree;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "DTree 插件响应数据")
public class DTreeDTO {
    @ApiModelProperty(value = "状态")
    private DTreeStatus status;
    @ApiModelProperty(value = "树的数据")
    private List<DTreeData> data;
}
