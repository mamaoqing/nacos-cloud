package com.mq.nacos.controller;

import com.mq.cloud.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author mq
 * @description: TODO
 * @title: WebController
 * @projectName nacos-cloud
 * @date 2020/11/2616:40
 */
@RestController
@RequestMapping("/web/")
@Slf4j
public class WebController {

    @Value("${service-url.nacos-pay-service}")
    private String serverUrl;

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("{id}")
    public String index(@PathVariable("id") String id) {
        log.info("已经进入web系统，获取到的内容为:{}",id);
        if(true) {
            throw new MyException(5001,"没有为啥就是错了！");
        }

        return restTemplate.getForObject(serverUrl+"/pay/"+id,String.class);
    }
}
