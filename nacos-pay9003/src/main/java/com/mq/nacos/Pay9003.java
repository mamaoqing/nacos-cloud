package com.mq.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author mq
 * @description: TODO
 * @title: Pay9001
 * @projectName nacos-cloud
 * @date 2020/11/2616:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Pay9003 {

    public static void main(String[] args) {
        SpringApplication.run(Pay9003.class,args);
    }
}
