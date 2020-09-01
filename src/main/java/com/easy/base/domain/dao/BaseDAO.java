package com.easy.base.domain.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode
public class BaseDAO {
    private boolean valid;
    private String CreateBy;
    private Timestamp CreateDt;
    private String UpdateBy;
    private Timestamp UpdateDt;
}
