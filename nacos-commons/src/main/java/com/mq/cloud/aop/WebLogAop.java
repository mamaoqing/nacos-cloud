package com.mq.cloud.aop;

import com.mq.cloud.exception.MyException;
import com.mq.nacos.entity.SUser;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author mq
 * @description: TODO
 * @title: WebLogAop
 * @projectName nacos-cloud
 * @date 2020/12/111:19
 */
@Aspect
@Component
@Slf4j
public class WebLogAop {

    @Pointcut("execution(public * com.mq.nacos.*.*.*(..))")
    public void aopLog() {
    }

    @Before("aopLog()")
    public void before(JoinPoint point) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        writeLog(point,request);
    }

    private void writeLog(JoinPoint point,HttpServletRequest request){
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(point.getArgs()));
    }
}
