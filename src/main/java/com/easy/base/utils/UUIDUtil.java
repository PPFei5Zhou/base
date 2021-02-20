package com.easy.base.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDUtil {
    /** 生成UUID */
    public String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
