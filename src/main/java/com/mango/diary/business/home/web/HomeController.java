package com.mango.diary.business.home.web;

import com.mango.diary.business.bit.service.BitRecordService;
import com.mango.diary.business.bit.vo.TimeLineVO;
import com.mango.diary.business.common.service.FileUploaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Author: Mango Cheng
 * Date: 2019/12/21
 * Time: 19:25
 * Description: 首页
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Resource(name = "bitRecordServiceImpl")
    private BitRecordService bitRecordService;

    @Autowired
    private FileUploaderService fileUploaderService;

    @PostMapping("/fetchTimeLines")
    public TimeLineVO fetchTimeLines() {
        LOGGER.info("[Method:fetchTimeLines]");
        TimeLineVO timeLineVO = new TimeLineVO();
        BeanUtils.copyProperties(bitRecordService.findById(1),timeLineVO);

        LOGGER.info("[Data:timeLineVO]" + timeLineVO.toString());
        return timeLineVO;
    }

    @PostMapping("/download")
    public void downloadFile(@RequestBody TimeLineVO timeLineVO){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        try {
            fileUploaderService.downloadFileInfo(request,response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

//        return "success";
    }

    @PostMapping("/downloadFileInfo")
    public String downloadFileInfo( HttpServletRequest request, HttpServletResponse response){
        try {
            fileUploaderService.downloadFileInfo(request,response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "success";
    }

}
