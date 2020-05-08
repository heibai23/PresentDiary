package com.mango.diary.business.common.controller;

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

    @PostMapping("/upload")
    public String uploadFile(@RequestParam(name = "file")MultipartFile file){


        return "";
    }



}
