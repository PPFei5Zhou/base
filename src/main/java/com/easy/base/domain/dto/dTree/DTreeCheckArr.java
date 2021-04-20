package com.easy.base.domain.dto.dTree;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "DTree 复选框设计类")
public class DTreeCheckArr {
    @ApiModelProperty(value = "复选框标记")
    private String type;

    @ApiModelProperty(value = "复选框是否选中")
    private String checked;
}
