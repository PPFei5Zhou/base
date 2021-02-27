package com.easy.base.service.user;

import com.easy.base.domain.dao.UserInfoDAO;
import com.easy.base.service.IBaseService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserServer extends IBaseService<UserInfoDAO>, UserDetailsService { }
