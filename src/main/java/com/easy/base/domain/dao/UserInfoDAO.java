package com.easy.base.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDAO {
    private String id;
    private String userName;
    private String account;
    private String password;
    private boolean valid;
    private String createBy;
    private Timestamp createDt;
    private String updateBy;
    private Timestamp updateDt;
}