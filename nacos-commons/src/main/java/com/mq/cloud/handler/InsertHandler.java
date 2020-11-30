package com.mq.cloud.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author mq
 * @description: TODO
 * @title: InsertHandler
 * @projectName nacos-cloud
 * @date 2020/11/309:42
 */
@Component
public class InsertHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        if(metaObject.hasSetter("createTime")){
            this.setFieldValByName("createTime",new Date(),metaObject);
        }
        if(metaObject.hasSetter("updateTime")) {
            this.setFieldValByName("updateTime", new Date(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if(metaObject.hasSetter("updateTime")){
            this.setFieldValByName("updateTime",new Date(),metaObject);
        }
    }
}
