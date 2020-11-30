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

    /**
     * 通过id获取用户信息
     * @param id  唯一id
     * @return 返回一个commonResult
     */
    CommonsResult<SUser> getUserById(Long id);

    /**
     * 保存用户信息
     * @param user  唯一id
     * @return 返回一个commonResult
     */
    CommonsResult<Integer> saveUser(SUser user);

    /**
     * 通过id删除用户
     * @param id  唯一id
     * @return 返回一个commonResult
     */
    CommonsResult<Integer> deleteUserById(Long id);

    /**
     * 通过id更新用户信息
     * @param user  用户信息
     * @return 返回一个commonResult
     */
    CommonsResult<Integer> updateUserById(SUser user);

    /**
     * 验证用户密码是否正确
     * @param userName  用户名
     * @param password  用户输入的密码
     * @return 返回一个commonResult
     */
    CommonsResult<Boolean> checkPassword(String userName,String password);
}
