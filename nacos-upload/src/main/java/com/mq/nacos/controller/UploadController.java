package com.mq.nacos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mq
 * @description: TODO
 * @title: UploadController
 * @projectName nacos-cloud
 * @date 2020/11/3014:29
 */
@Controller
@RequestMapping("/upload/")
public class UploadController {


    @GetMapping("index")
    public String index(){
        return "index";
    }
}
