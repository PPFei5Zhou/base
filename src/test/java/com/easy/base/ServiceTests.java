package com.easy.base;

import javax.annotation.Resource;

import com.easy.base.domain.dto.ResultDTO;
import com.easy.base.domain.dto.user.UserDTO;
import com.easy.base.service.impl.user.RoleInfoService;
import com.easy.base.service.impl.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.easy.base.dao.mapper")
@ComponentScan("com.easy.base")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServiceTests {
    @Resource
    private UserService userService;

    @Resource
    private RoleInfoService roleInfoService;

    @Test
    public void userServiceTest() {
        UserDTO dto = new UserDTO();
        dto.setUserAccount("admin");
        dto.setMethodName("");
        ResultDTO<UserDTO> resultDTO = userService.selectEntityByID("admin");
        log.error(resultDTO.toString());
    }

    @Test
    public void roleHierarchyChain() {
        log.info(roleInfoService.roleHierarchyChain());
    }
}
