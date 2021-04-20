package com.easy.base.domain.dto.dTree;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "DTree 数据设置")
public class DTreeData {
    @ApiModelProperty(value = "节点ID")
    private String id;

    @ApiModelProperty(value = "链接")
    private String url;

    @ApiModelProperty(value = "节点名称")
    private String title;

    @ApiModelProperty(value = "层级")
    private int level;

    @ApiModelProperty(value = "上级节点ID")
    private String parentId;

    @ApiModelProperty(value = "复选框集合")
    private DTreeCheckArr checkArr;

    @ApiModelProperty(value = "子节点集合")
    private List<DTreeData> children;
}
