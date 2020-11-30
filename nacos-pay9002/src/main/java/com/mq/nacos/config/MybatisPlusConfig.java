package com.mq.nacos.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author mq
 * @description: TODO
 * @title: MybatisPlusConfig
 * @projectName nacos-cloud
 * @date 2020/11/309:58
 */
@Configuration
@MapperScan("com.mq.nacos.mapper")
public class MybatisPlusConfig {
//    private PathMatchingResourcePatternResolver resolver;
//
//    private Environment environment;
//
//    public MybatisPlusConfig(Environment environment, PathMatchingResourcePatternResolver resolver){
//        this.environment = environment;
//        this.resolver = resolver;
//    }

    // 分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
