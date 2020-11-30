package com.mq.nacos.controller;

import com.mq.cloud.util.CommonsResult;
import com.mq.nacos.entity.SUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mq
 * @description: TODO
 * @title: SUserController
 * @projectName nacos-cloud
 * @date 2020/11/309:50
 */
@RestController
@RequestMapping("/web/sUser/")
@Slf4j
public class SUserController {

    @Value("${service-url.nacos-pay-service}")
    private String serverUrl;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{id}")
    public CommonsResult<SUser> getUserById(@PathVariable("id") Long id){
        log.info("web接受的id:{}",id);
        return  restTemplate.getForObject(serverUrl+"/sUser/"+id,CommonsResult.class);
    }

    @PostMapping("saveUser")
    public CommonsResult<Integer> saveUser(SUser user){
        log.info("web收到的user对象是:{}",user);
        return  restTemplate.postForObject(serverUrl+"/sUser/saveUser",user,CommonsResult.class);
    }

    @DeleteMapping("{id}")
    public CommonsResult<Integer> deleteUserById(@PathVariable("id") Long id){
        restTemplate.delete(serverUrl+"/sUser/"+id);
        return restTemplate.getForObject(serverUrl+"/sUser/"+id,CommonsResult.class);
    }

    @PostMapping("/checkPassword")
    public CommonsResult<Boolean> checkPassword(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Map<String,String> map = new HashMap<>(16);
        map.put("userName",userName);
        map.put("password",password);
        return restTemplate.postForObject(serverUrl+"/sUser/checkPassword",map,CommonsResult.class);
    }
}
