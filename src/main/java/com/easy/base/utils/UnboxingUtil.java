package com.easy.base.utils;

import org.springframework.stereotype.Component;

@Component
public class UnboxingUtil {
    public int unboxingValue(Integer integer) {
        return integer != null ? integer : 0;
    }

    public long unboxingValue(Long l) {
        return l != null ? l : 0L;
    }

    public boolean unboxingValue(Boolean b) {
        return b != null ? b : false;
    }
}
