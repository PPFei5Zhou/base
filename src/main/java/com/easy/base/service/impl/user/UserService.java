package com.easy.base.service.impl.user;

import com.easy.base.domain.dao.user.UserRoleDAO;
import com.easy.base.repository.mapper.UserMapper;
import com.easy.base.domain.dto.user.UserDTO;
import com.easy.base.service.impl.BaseService;
import com.easy.base.service.user.IUserServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class UserService extends BaseService<UserDTO, UserMapper> implements IUserServer {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        UserDTO userInfoDAO = GetUserInfoDAO(username);
        if (userInfoDAO == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        for (UserRoleDAO ur : userInfoDAO.getUserRoles()) {
            authorities.add(new SimpleGrantedAuthority(ur.getRoleInfo().getRoleCode()));
        }
        return new User(userInfoDAO.getUserAccount(), userInfoDAO.getPassword(), authorities);
    }

    private UserDTO GetUserInfoDAO(String account) {
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserAccount(account);
            List<UserDTO> list = mapper.selectEntities(userDTO, 1, Integer.MAX_VALUE);
            return list.stream().findFirst().orElse(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
