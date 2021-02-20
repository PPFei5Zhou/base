package com.easy.base.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "user_info")
public class UserInfoEntity implements Serializable {
    private static final long serialVersionUID = 2432808679310666404L;

    @Id
    @Column(name= "ID", unique = true, nullable = false)
    private String id;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "UserAccount", unique = true)
    private String userAccount;

    @Column(name = "Password")
    private String password;

    @Column(name = "Valid")
    private boolean valid;

    @Column(name = "CreateBy")
    private String createBy;

    @Column(name = "CreateDt")
    private Timestamp createDt;

    @Column(name = "UpdateBy")
    private String updateBy;

    @Column(name = "UpdateDt")
    private Timestamp updateDt;
}
