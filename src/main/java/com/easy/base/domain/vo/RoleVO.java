package com.easy.base.domain.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class RoleVO implements Serializable {
    private static final long serialVersionUID = -4161211208532197339L;
    private int id;
    private String roleName;
}
