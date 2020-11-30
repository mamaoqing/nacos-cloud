package com.mq.nacos.service;

import com.mq.cloud.util.CommonsResult;
import com.mq.nacos.entity.SUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mq
 * @since 2020-11-30
 */
public interface SUserService extends IService<SUser> {

    CommonsResult<SUser> getUserById(Long id);

    CommonsResult<Integer> saveUser(SUser user);

    CommonsResult<Integer> deleteUserById(Long id);

    CommonsResult<Integer> updateUserById(SUser user);

    CommonsResult<Boolean> checkPassword(String userName,String password);
}
