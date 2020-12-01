package com.mq.nacos.handler;

import com.mq.cloud.exception.MyException;
import com.mq.cloud.util.CommonsResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author mq
 * @description: 统一异常捕获。
 * @title: HandlerExceptionUtil
 * @projectName nacos-cloud
 * @date 2020/12/110:53
 */
@Slf4j
@RestControllerAdvice(basePackages = {"com.mq.nacos.controller"})
public class HandlerExceptionUtil {

    @ExceptionHandler(MyException.class)
    public CommonsResult handlerException(MyException myException) {
        return new CommonsResult(myException.getCode(), myException.getMessage());
    }

}
