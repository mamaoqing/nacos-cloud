package com.mq.nacos.controller;

import com.mq.cloud.util.PasswordEncryption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mq
 * @description: TODO
 * @title: PayController
 * @projectName nacos-cloud
 * @date 2020/11/2616:36
 */
@RestController
@RequestMapping("/pay/")
public class PayController {

    @Value("${server.port}")
    private String port;

    @GetMapping("{id}")
    public String pay(@PathVariable("id") String id){
        String mmq = PasswordEncryption.encryption(id, "mmq");
        System.out.println(mmq);

        return "访问端口号是<"+port+">的服务,获取到的id内容是："+ mmq;
    }
}
