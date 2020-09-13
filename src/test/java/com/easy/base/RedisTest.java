package com.easy.base;

import com.easy.base.utils.RedisUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.easy.base")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RedisTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void TestRedis() {
        boolean result = redisUtil.set("key", "value");
        logger.info(String.valueOf(result));
        Object object = redisUtil.get("key");
        logger.info(String.valueOf(object));
        redisUtil.del("key");
        object = redisUtil.get("key");
        logger.info(String.valueOf(object));
    }
}