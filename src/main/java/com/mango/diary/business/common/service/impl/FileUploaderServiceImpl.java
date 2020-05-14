package com.mango.diary.business.common.service.impl;

import com.mango.diary.business.common.dao.FileInfoDAO;
import com.mango.diary.business.common.po.TFileInfo;
import com.mango.diary.business.common.service.FileUploaderService;
import com.mango.diary.business.home.web.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Author：Mango Cheng
 * Date：2020/1/18
 * Time：19:37
 * Description：文件上传处理
 */
@Component
public class FileUploaderServiceImpl implements FileUploaderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private FileInfoDAO fileInfoDAO;

    @Override
    public void saveFileInfo(MultipartFile[] files) {
        if (files == null || files.length == 0) {
            LOGGER.info("[Methods:saveFileInfo][Result:files无数据]");
            return;
        }
        for (MultipartFile file : files) {
            this.saveFileInfo(file);
        }

    }

    @Override
    public void saveFileInfo(MultipartFile file) {
        TFileInfo fileInfo = new TFileInfo();
        String name = file.getName();
        String type = file.getContentType();
        fileInfo.setId("23");
        fileInfo.setName("44");
        try {
            fileInfo.setData(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileInfoDAO.save(fileInfo);
    }

    @Override
    public String downloadFileInfo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //下载逻辑：
        // 设置强制下载不打开
        response.setContentType("application/force-download");
        // 设置文件名，fileName是下载文件的文件名
        response.addHeader("Content-Disposition",
                "attachment;fileName=" + URLEncoder.encode("23.png", "UTF-8"));
        byte[] buffer = new byte[1024];
        //需要下载文件的字节数组
        TFileInfo fileInfo = new TFileInfo();
        BeanUtils.copyProperties(fileInfoDAO.getOne("23"), fileInfo);
//        TFileInfo fileInfo = fileInfoDAO.findById("23");
        byte[] modelByte = fileInfo.getData();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(modelByte);
        try {
            OutputStream out = response.getOutputStream();
            int i = byteArrayInputStream.read(buffer);
            while (i != -1) {
                out.write(buffer, 0, i);
                i = byteArrayInputStream.read(buffer);
            }
            out.flush();
            System.out.println("********************下载success**************");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "success";
    }


}
