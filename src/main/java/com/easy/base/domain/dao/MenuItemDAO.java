package com.easy.base.domain.dao;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemDAO extends BaseDAO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String menuUrl;

    private String menuName;

    private Integer menuSort;

    private Integer menuLevel;

    private String parentId;

    private List<MenuItemDAO> childMenu;
}