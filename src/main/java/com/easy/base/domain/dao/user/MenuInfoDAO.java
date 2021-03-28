package com.easy.base.domain.dao.user;

import java.io.Serializable;
import java.util.List;

import com.easy.base.domain.dao.BaseDAO;
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

    private String menuUrl;

    private String menuName;

    private Integer menuSort;

    private Integer menuLevel;

    private String parentId;

    private List<MenuInfoDAO> childMenu;
}