package com.mango.diary.business.common.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Author：Mango Cheng
 * Date：2020/1/18
 * Time：19:36
 * Description：文件处理
 */
public interface FileUploaderService {
    /**
     * 保存文件-多个
     * @param files
     */
    void saveFileInfo(MultipartFile[] files);

    /**
     * 保存文件-单个
     * @param file
     */
    void saveFileInfo(MultipartFile file);

    /**
     * 下载文件
     * @param request
     * @param response
     * @return
     */
    String downloadFileInfo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException;
}
