package com.mango.diary.business.common.controller;

import com.alibaba.fastjson.JSON;
import com.mango.diary.business.home.web.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Author：Mango Cheng
 * Date：2020/1/15
 * Time：19:51
 * Description：文件上传入口
 */

@RestController
@RequestMapping("/file")
public class FileUploader {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @PostMapping("/upload")
    public String uploadFile(@RequestParam(name = "file")MultipartFile file){

        LOGGER.info(JSON.toJSONString(file));
        return "success";
    }



}
