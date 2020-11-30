package com.mq.nacos.controller;


import com.mq.cloud.util.CommonsResult;
import com.mq.nacos.entity.SUser;
import com.mq.nacos.service.SUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mq
 * @since 2020-11-30
 */
@RestController
@RequestMapping("/sUser")
@Slf4j
public class SUserController {

    @Autowired
    private SUserService userService;

    @GetMapping("/{id}")
    public CommonsResult<SUser> getUserById(@PathVariable("id") Long id) {
        log.info("获取用户的id：{}",id);
        return userService.getUserById(id);
    }

    @PostMapping("/saveUser")
    public CommonsResult<Integer> saveUser(@RequestBody SUser user) {
        log.info("获取用户的信息是：{}",user);
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public CommonsResult<Integer> deleteUserById(@PathVariable("id") Long id) {
        log.info("删除用户的id：{}",id);
        return userService.deleteUserById(id);
    }

    @PutMapping("/updateUserById")
    public CommonsResult<Integer>  updateUserById(@RequestBody SUser user){
        log.info("获取用户的信息是：{}",user);
        return userService.updateUserById(user);
    }

    @PostMapping("/checkPassword")
    public CommonsResult<Boolean> checkPassword(@RequestBody Map<String,String> map){
        String userName = map.get("userName");
        String password = map.get("password");
        return userService.checkPassword(userName, password);
    }
}

