package com.mq.nacos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    public String index() {
        return "index";
    }


    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        String result = "";
        if (file.isEmpty()) {
            return result;
        }
        try {
            String fileName = file.getOriginalFilename();

            File destFile = new File("/usr/local/nginx/mq/" + File.separator + fileName);
            boolean mkdirs = destFile.getParentFile().mkdirs();
            file.transferTo(destFile);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

