package com.easy.base.domain.dto.user;

import com.easy.base.domain.dao.user.UserInfoDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends UserInfoDAO {
    private int page;
    private int pageSize;
    private String methodName;
}
