package com.easy.base.domain.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode
public class BaseDAO implements Cloneable {
    @ApiModelProperty("ID")
    private String id;
    @ApiModelProperty("有效")
    private boolean valid;
    @ApiModelProperty("创建")
    private String createBy;
    @ApiModelProperty("修改")
    private String updateBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty("创建时间")
    private Timestamp createDt;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty("修改时间")
    private Timestamp updateDt;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
