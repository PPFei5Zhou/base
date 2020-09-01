package com.easy.base.domain.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class UserVO implements Serializable {
    private static final long serialVersionUID = -2623779465751141252L;
    private String id;
    private String username;
    private String account;
    private List<RoleVO> roles;
}
