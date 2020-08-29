package com.easy.base.service.impl;

import com.easy.base.dao.jpa.UserRepository;
import com.easy.base.dao.mapper.UserMapper;
import com.easy.base.domain.dao.UserInfoDAO;
import com.easy.base.domain.dto.BaseDTO;
import com.easy.base.domain.dto.JsonResult;
import com.easy.base.domain.dto.UserDTO;
import com.easy.base.domain.entity.UserInfoEntity;
import com.easy.base.domain.vo.UserVO;
import com.easy.base.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements BaseService {
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
        return new JsonResult();
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
            jsonResult.setErrorResult("參數不能為 NULL!");
            result = jsonResult;
        } else {
            UserDTO userDTO = (UserDTO) dto;
            String type = userDTO.getMethodName();
            if (type.trim().isEmpty()) {
                jsonResult.setErrorResult("參數不能為空字符串!");
                result = jsonResult;
            } else if ("ListBaseUserInfo".equals(type)) {
                result = listBaseUserInfo(userDTO);
            } else if ("FindAll".equals(type)) {
                result = findAll();
            } else if ("FindByUserNameLike".equals(type)) {
                result = findByUserNameLike(userDTO);
            } else if ("login".equals(type)) {
                result = login(userDTO);
            } else {
                jsonResult.setErrorResult("沒有找到對應的方法, 請確認!");
                result = jsonResult;
            }
        }

        return result;
    }

    private JsonResult listBaseUserInfo(UserDTO dto) {
        JsonResult jsonResult = new JsonResult();
        try {
            List<UserInfoDAO> list = userMapper.listUser(dto);
            jsonResult.setList(list.size(), list);
        } catch (Exception ex) {
            jsonResult.setErrorResult(ex.getMessage());
        }
        return jsonResult;
    }

    private JsonResult findAll() {
        JsonResult jsonResult = new JsonResult();
        try {
            List<UserInfoEntity> list = userRepository.findAll();
            jsonResult.setList(list.size(), list);
        } catch (Exception ex) {
            jsonResult.setErrorResult(ex.getMessage());
        }
        return jsonResult;
    }

    private JsonResult findByUserNameLike(UserDTO dto) {
        JsonResult jsonResult = new JsonResult();
        try {
            List<UserInfoEntity> list = userRepository.findByUserNameContaining(dto.getUserName());
            jsonResult.setList(list.size(), list);
        } catch (Exception ex) {
            jsonResult.setErrorResult(ex.getMessage());
        }
        return jsonResult;
    }

    private JsonResult login(UserDTO dto) {
        JsonResult jsonResult = new JsonResult();
        try {
            UserInfoEntity userinfo = userRepository.findByAccountAndPasswordAndValidIsTrue(dto.getUserAccount(), dto.getPassword());
            if (userinfo != null) {
                UserVO userVo = new UserVO();
                userVo.setId(userinfo.getId());
                userVo.setAccount(userinfo.getAccount());
                userVo.setUsername(userinfo.getUserName());
                jsonResult.setObject(userVo);
            } else {
                jsonResult.setErrorResult("账号/密码不正确");
            }
        } catch (Exception ex) {
            jsonResult.setErrorResult(ex.getMessage());
        }
        return jsonResult;
    }
}
