package com.easy.base.domain.dto.dTree;

import lombok.Data;

import java.util.List;

@Data
public class DTreeData {
    private String id;
    private String url;
    private String title;
    private int level;
    private String parentId;
    private DTreeCheckArr checkArr;
    private List<DTreeData> children;
}
