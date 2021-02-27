package com.easy.base.domain.dto.dTree;

import lombok.Data;

import java.util.List;

@Data
public class DTreeDTO {
    private DTreeStatus status;
    private List<DTreeData> data;
}
