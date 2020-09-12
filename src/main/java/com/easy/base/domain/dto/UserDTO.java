package com.easy.base.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO {
    public UserDTO(String userAccount, String password) {
        this.userAccount = userAccount;
        this.password = password;
    }

    private String id;
    private String userAccount;
    private String userName;
    private String password;
}
