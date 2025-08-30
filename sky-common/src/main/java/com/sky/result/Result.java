package com.sky.result;

import lombok.Data;

/**
 * 返回结果
 */
@Data
public class Result<T> {
    private Integer code;   // 响应代码 1->成功 0|other->失败
    private String msg;     // 响应信息
    private T data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.data = object;
        result.code = 1;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.msg = msg;
        result.code = 0;
        return result;
    }
}
