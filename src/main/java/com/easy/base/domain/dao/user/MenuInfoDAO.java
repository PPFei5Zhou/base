package com.easy.base.domain.dao.user;

import java.io.Serializable;
import java.util.List;

import com.easy.base.domain.dao.BaseDAO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class MenuInfoDAO extends BaseDAO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("链接")
    private String menuUrl;

    @ApiModelProperty("名称")
    private String menuName;

    @ApiModelProperty("排序")
    private Integer menuSort;

    @ApiModelProperty("层级")
    private Integer menuLevel;

    @ApiModelProperty("父菜单ID")
    private String parentId;

    @ApiModelProperty("子菜单")
    private List<MenuInfoDAO> childMenu;
}