package com.mq.cloud.exception;

/**
 * @author mq
 * @description: TODO
 * @title: MyException
 * @projectName nacos-cloud
 * @date 2020/12/110:54
 */
public class MyException extends RuntimeException {

    private final Integer code;

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
