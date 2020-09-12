package com.easy.base.service.impl;

import com.easy.base.dao.jpa.UserRepository;
import com.easy.base.dao.mapper.UserMapper;
import com.easy.base.domain.dao.RoleInfoDAO;
import com.easy.base.domain.dao.UserInfoDAO;
import com.easy.base.domain.dto.BaseDTO;
import com.easy.base.domain.dto.JsonResult;
import com.easy.base.domain.dto.UserDTO;
import com.easy.base.domain.entity.UserInfoEntity;
import com.easy.base.domain.vo.UserVO;
import com.easy.base.service.BaseService;
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
import java.util.Optional;

@Service
public class UserServiceImpl implements BaseService, UserDetailsService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public JsonResult saveObject(BaseDTO dto) {
        return new JsonResult();
    }

    @Override
    public JsonResult updateObject(BaseDTO dto) {
        return new JsonResult();
    }

    @Override
    public JsonResult removeObject(BaseDTO dto) {
        return new JsonResult();
    }

    @Override
    public JsonResult getSingleObject(BaseDTO dto) {
        JsonResult jsonResult = new JsonResult();
        if (dto == null) {
            jsonResult.failed("参数不能为空");
        }
        UserDTO userDTO = (UserDTO) dto;
        Optional<UserInfoEntity> optional = userRepository.findById(userDTO.getId());
        
        if (!optional.isPresent()) {
            jsonResult.failed("未查到此账号");
            return jsonResult;
        }

        UserVO userVO = new UserVO();
        userVO.setId(optional.get().getId());
        userVO.setAccount(optional.get().getAccount());
        userVO.setUsername(optional.get().getUserName());
        jsonResult.success(userVO);
        return jsonResult;
    }

    /**
     * <p>UserInfo 查詢結果集</p>
     * <p>dto 的 methodType 可賦值為:</p>
     * <p>1. "ListBaseUserInfo" 查詢 USERINFO 表</p>
     * <p>2. "FindAll" 查詢 USERINFO 表</p>
     * <p>3. "FindByUserNameLike" 查詢 USERINFO 表的 UserName</p>
     * <p>4. "login" 登陸校驗</p>
     * @param dto UserDTO
     * @return ResponseDTO
     */
    @Override
    public JsonResult listObjectFactory(BaseDTO dto) {
        JsonResult jsonResult = new JsonResult();
        JsonResult result;
        if (dto == null) {
            jsonResult.failed("參數不能為 NULL!");
            result = jsonResult;
        } else {
            UserDTO userDTO = (UserDTO) dto;
            String type = userDTO.getMethodName();
            if (type.trim().isEmpty()) {
                jsonResult.failed("參數不能為空字符串!");
                result = jsonResult;
            } else if ("ListBaseUserInfo".equals(type)) {
                result = listBaseUserInfo(userDTO);
            } else if ("FindAll".equals(type)) {
                result = findAll();
            } else if ("FindByUserNameLike".equals(type)) {
                result = findByUserNameLike(userDTO);
            } else {
                jsonResult.failed("沒有找到對應的方法, 請確認!");
                result = jsonResult;
            }
        }

        return result;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        UserInfoDAO userInfoDAO = GetUserInfoDAO(username);
        if (userInfoDAO == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        for (RoleInfoDAO role : userInfoDAO.getUserRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new User(userInfoDAO.getId(), userInfoDAO.getPassword(), authorities);
    }

    private JsonResult listBaseUserInfo(UserDTO dto) {
        JsonResult jsonResult = new JsonResult();
        try {
            List<UserInfoDAO> list = userMapper.listUser(dto);
            jsonResult.setList(list.size(), list);
        } catch (Exception ex) {
            jsonResult.failed(ex.getMessage());
        }
        return jsonResult;
    }

    private JsonResult findAll() {
        JsonResult jsonResult = new JsonResult();
        try {
            List<UserInfoEntity> list = userRepository.findAll();
            jsonResult.setList(list.size(), list);
        } catch (Exception ex) {
            jsonResult.failed(ex.getMessage());
        }
        return jsonResult;
    }

    private JsonResult findByUserNameLike(UserDTO dto) {
        JsonResult jsonResult = new JsonResult();
        try {
            List<UserInfoEntity> list = userRepository.findByUserNameContaining(dto.getUserName());
            jsonResult.setList(list.size(), list);
        } catch (Exception ex) {
            jsonResult.failed(ex.getMessage());
        }
        return jsonResult;
    }

    private UserInfoDAO GetUserInfoDAO(String account) {
        try {
            return userMapper.userInfo(account);
        } catch (Exception ex) {
            System.out.println("GetUserInfoDAO, " + ex.getMessage());
            return null;
        }
    }
}
