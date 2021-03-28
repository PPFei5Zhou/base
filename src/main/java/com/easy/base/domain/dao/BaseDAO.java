package com.easy.base.domain.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode
public class BaseDAO implements Cloneable {
    private String id;
    private boolean valid;
    private String createBy;
    private String updateBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp createDt;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp updateDt;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
