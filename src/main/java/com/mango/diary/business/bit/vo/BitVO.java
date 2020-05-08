package com.mango.diary.business.bit.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Author：Mango Cheng
 * Date：2020/1/18
 * Time：11:52
 * Description：记点滴模块
 */
public class BitVO {

    /**
     * 表单参数：TimeLineVO
     */
    private String param;

    /**
     * 附件列表
     */
    private MultipartFile[] files;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
