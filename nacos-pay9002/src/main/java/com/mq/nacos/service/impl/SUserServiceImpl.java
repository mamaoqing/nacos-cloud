package com.mq.nacos.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mq.cloud.util.CommonsResult;
import com.mq.cloud.util.PasswordEncryption;
import com.mq.nacos.entity.SUser;
import com.mq.nacos.mapper.SUserMapper;
import com.mq.nacos.service.SUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mq
 * @since 2020-11-30
 */
@Service
public class SUserServiceImpl extends ServiceImpl<SUserMapper, SUser> implements SUserService {
    @Autowired
    private SUserMapper userMapper;

    @Override
    public CommonsResult<SUser> getUserById(Long id) {
        SUser sUser = userMapper.selectById(id);
        if(null == sUser){
            return new CommonsResult<>(500,"error");
        }
        return new CommonsResult<>(200,"success",sUser);
    }

    @Override
    public CommonsResult<Integer> saveUser(SUser user) {
        String password = user.getPassword();
        QueryWrapper<SUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",user.getUserName());
        SUser sUser = userMapper.selectOne(queryWrapper);
        if(null != sUser){
            return new CommonsResult<>(500,"用户已经存在");
        }
        user.setPassword(PasswordEncryption.encryption(password));
        int insert = userMapper.insert(user);
        if(insert > 0){
            return new CommonsResult<>(200,"success");
        }
        return new CommonsResult<>(500,"error");
    }

    @Override
    public CommonsResult<Integer> deleteUserById(Long id) {
        int delete = userMapper.deleteById(id);

        if(delete > 0){
            return new CommonsResult<>(200,"success");
        }
        return new CommonsResult<>(500,"error");
    }

    @Override
    public CommonsResult<Integer> updateUserById(SUser user) {
        int update = userMapper.updateById(user);
        if(update > 0){
            return new CommonsResult<>(200,"success");
        }
        return new CommonsResult<>(500,"error");
    }

    @Override
    public CommonsResult<Boolean> checkPassword(String userName, String password) {
        QueryWrapper<SUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userName);
        SUser sUser = userMapper.selectOne(queryWrapper);
        if(null == sUser){
            return new CommonsResult<>(500,"用户不存在");
        }
        String password1 = sUser.getPassword();
        if(PasswordEncryption.decode(password1, password)){
            return new CommonsResult<Boolean>(200,"success");
        }
        return new CommonsResult<Boolean>(500,"密码错误");
    }
}
