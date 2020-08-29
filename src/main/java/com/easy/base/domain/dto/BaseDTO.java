package com.easy.base.domain.dto;

import lombok.Data;

@Data
public class BaseDTO {
    private int page;
    private int pageSize;
    private String methodName;
}
