package com.easy.base.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class JsonResult implements Serializable {
    private static final long serialVersionUID = 2757646236478345787L;

    /**
     * 設置 List 結果
     * @param listTotalCount List 列表總數
     * @param obj List 類型
     */
    public void setList(int listTotalCount, Object obj) {
        this.result = true;
        this.listTotalCount = listTotalCount;
        this.message = "";
        this.obj = obj;
    }

    /**
     * 設置 Object 返回結果
     * @param obj 任意類型
     */
    public void setObject(Object obj) {
        this.result = true;
        this.listTotalCount = 0;
        this.message = "";
        this.obj = obj;
    }

    /**
     * 設置錯誤狀態的返回類型
     */
    public void setErrorResult() {
        this.result = false;
        this.obj = null;
        this.listTotalCount = 0;
    }

    /**
     * 設置錯誤信息的返回類型
     * @param message 自定義的錯誤信息
     */
    public void setErrorResult(String message) {
        setErrorResult();
        this.message = message;
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
    private Object obj;

    /**
     * 列表總數
     */
    private int listTotalCount;
}
