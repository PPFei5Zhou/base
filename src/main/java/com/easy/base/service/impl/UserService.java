package com.easy.base.service.impl;

import com.easy.base.domain.dao.UserRoleDAO;
import com.easy.base.repository.mapper.UserMapper;
import com.easy.base.domain.dao.UserInfoDAO;
import com.easy.base.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class UserService extends BaseService<UserInfoDAO, UserMapper> implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        UserInfoDAO userInfoDAO = GetUserInfoDAO(username);
        if (userInfoDAO == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        for (UserRoleDAO ur : userInfoDAO.getUserRoles()) {
            authorities.add(new SimpleGrantedAuthority(ur.getRoleInfo().getRoleCode()));
        }
        return new User(userInfoDAO.getUserAccount(), userInfoDAO.getPassword(), authorities);
    }

    private UserInfoDAO GetUserInfoDAO(String account) {
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserAccount(account);
            List<UserInfoDAO> list = mapper.selectEntities(userDTO, 1, Integer.MAX_VALUE);
            return list.stream().findFirst().orElse(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
