package com.easy.base.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class ResultDTO<T> implements Serializable {
    private static final long serialVersionUID = 2757646236478345787L;

    ResultDTO(boolean result) {
        this.result = result;
        this.message = "";
        this.obj = null;
        this.count = 0;
    }

    ResultDTO(boolean result, String message) {
        this.result = result;
        this.message = message;
        this.obj = null;
        this.count = 0;
    }

    ResultDTO(boolean result, T obj) {
        this.result = result;
        this.message = "";
        this.obj = obj;
        this.count = 0;
    }

    ResultDTO(boolean result, T obj, String message) {
        this.result = result;
        this.message = message;
        this.obj = obj;
        this.count = 0;
    }

    ResultDTO(boolean result, T obj, int count) {
        this.result = result;
        this.message = "";
        this.obj = obj;
        this.count = count;
    }

    public static <T> ResultDTO<T> CreateResult(boolean result) {
        return new ResultDTO<>(result);
    }

    public static <T> ResultDTO<T> CreateResult(boolean result, String message) {
        return new ResultDTO<>(result, message);
    }

    public static <T> ResultDTO<T> CreateResult(boolean result, T obj, int count) {
        return new ResultDTO<>(result, obj, count);
    }

    public static <T> ResultDTO<T> CreateResult(boolean result, T obj) {
        return new ResultDTO<>(result, obj);
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
