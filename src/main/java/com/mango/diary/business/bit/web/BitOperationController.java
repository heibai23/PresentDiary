package com.mango.diary.business.bit.web;

import com.mango.diary.business.bit.service.BitRecordService;
import com.mango.diary.business.bit.vo.TimeLineVO;
import com.mango.diary.business.common.service.FileUploaderService;
import com.mango.diary.business.home.web.HomeController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Mango Cheng
 * Date: 2019/12/21
 * Time: 19:25
 * Description: 点滴操作
 */
@RestController
@RequestMapping("/bit")
@Api(tags = {"点滴操作"})
public class BitOperationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private FileUploaderService fileUploaderService;

    @Autowired
    private BitRecordService bitRecordService;

    /**
     * 记点滴
     *
     * @param timeLineVO
     * @return
     */
    @PostMapping("/recordBit")
    @ApiOperation(value = "记点滴", notes = "记录点滴操作方法")
    public String recordBit(@RequestBody(required = true) TimeLineVO timeLineVO) {
        LOGGER.info("[Api:/bit/recordBit][Methods:recordBit][params:timeLineVO]" + timeLineVO.toString());
        bitRecordService.saveOrUpdate(timeLineVO.getType(), timeLineVO);

        return "success";
    }

    /*@PostMapping("/recordBit")
    public String recordBit(@ModelAttribute BitVO bitVO) {
        LOGGER.info("[Api:/bit/recordBit][Methods:recordBit][params:BitVO]" + bitVO.toString());
        fileUploaderService.saveFileInfo(bitVO.getFiles());
        // 提取参数
        TimeLineVO timeLineVO = JSONObject.parseObject(bitVO.getParam(), TimeLineVO.class);
        LOGGER.info("[Api:/bit/recordBit][Methods:recordBit][params:timeLineVO]" + timeLineVO.toString());
        bitRecordService.saveOrUpdate(timeLineVO.getType(), timeLineVO);

        return "success";
    }*/

    /**
     * 获取时间轴数据
     *
     * @param id 预留参数
     * @return
     */
    @GetMapping("/fetchTimeLines/{id}")
    @ApiOperation(value = "获取时间轴数据", notes = "获取点滴集合")
    public List<TimeLineVO> fetchTimeLines(@PathVariable(value = "id") String id) {
        LOGGER.info("[Api:/bit/fetchTimeLines][Mehtods:fetchBitData]");
        List<TimeLineVO> timeLineVOList = bitRecordService.fetchBitData();

        return timeLineVOList;
    }


}
