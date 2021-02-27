package com.easy.base.domain.dao;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode
public class BaseDAO {
    private String id;
    private boolean valid;
    private String createBy;
    private Timestamp createDt;
    private String updateBy;
    private Timestamp updateDt;
}
