package com.mq.cloud.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mq
 * @description: TODO
 * @title: CommonsResult
 * @projectName nacos-cloud
 * @date 2020/11/309:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonsResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonsResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
