package com.easy.base;

import com.easy.base.domain.dto.JsonResult;
import com.easy.base.domain.dto.UserDTO;
import com.easy.base.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.easy.base.dao.mapper")
@ComponentScan("com.easy.base")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ServiceTests {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void userServiceTest() {
        UserDTO dto = new UserDTO();
        dto.setUserAccount("admin");
        dto.setMethodName("ListBaseUserInfo");
        JsonResult jsonResult = userService.listObjectFactory(dto);
        System.out.println(jsonResult.toString());
    }
}
