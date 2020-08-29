package com.easy.base.domain.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class UserVO implements Serializable {
    private String id;
    private String username;
    private String account;
}
