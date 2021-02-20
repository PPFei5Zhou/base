package com.easy.base.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = 2757646236478345787L;

    JsonResult(boolean result) {
        this.result = result;
        this.message = "";
        this.obj = null;
        this.count = 0;
    }

    JsonResult(boolean result, String message) {
        this.result = result;
        this.message = message;
        this.obj = null;
        this.count = 0;
    }

    JsonResult(boolean result, T obj) {
        this.result = result;
        this.message = "";
        this.obj = obj;
        this.count = 0;
    }

    JsonResult(boolean result, T obj, String message) {
        this.result = result;
        this.message = message;
        this.obj = obj;
        this.count = 0;
    }

    JsonResult(boolean result, T obj, int count) {
        this.result = result;
        this.message = "";
        this.obj = obj;
        this.count = count;
    }

    public static <T> JsonResult<T> CreateResult(boolean result) {
        return new JsonResult<>(result);
    }

    public static <T> JsonResult<T> CreateResult(boolean result, String message) {
        return new JsonResult<>(result, message);
    }

    public static <T> JsonResult<T> CreateResult(boolean result, T obj, int count) {
        return new JsonResult<>(result, obj, count);
    }

    public static <T> JsonResult<T> CreateResult(boolean result, T obj) {
        return new JsonResult<>(result, obj);
    }

    /**
     * 响应结果
     */
    private boolean result;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应对象
     */
    private T obj;

    /**
     * 列表總數
     */
    private int count;
}
