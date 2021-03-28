package com.easy.base.domain.dao.user;

import com.easy.base.domain.dao.BaseDAO;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class UserInfoDAO extends BaseDAO {
    private String userName;
    private String userAccount;
    private String password;
    private boolean valid;
    private String createBy;
    private Timestamp createDt;
    private String updateBy;
    private Timestamp updateDt;
    private List<UserRoleDAO> userRoles;
}