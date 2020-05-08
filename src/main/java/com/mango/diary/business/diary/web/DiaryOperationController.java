package com.mango.diary.business.diary.web;

import com.mango.diary.business.diary.po.TDiary;
import com.mango.diary.business.diary.service.DiaryService;
import com.mango.diary.business.diary.vo.DiaryVO;
import com.mango.diary.business.home.web.HomeController;
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author：Mango Cheng
 * Date：2020/2/20
 * Time：16:57
 * Description：日记操作
 */
@RestController
@RequestMapping("/diary")
public class DiaryOperationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiaryOperationController.class);

    @Autowired
    private DiaryService diaryService;

    @PostMapping("/writeDiary")
    public String writeDiary(@RequestBody DiaryVO diaryVO) {
        LOGGER.info("[Api:/diary/writeDiary][Methods:writeDiary][params:diaryVO]" + diaryVO.toString());
        TDiary diary = diaryService.saveOrUpdate(diaryVO);

        return "success";
    }

    @PostMapping("/fetchDiarySet/{id}")
    public List<DiaryVO> fetchDiarySet(@PathVariable(name = "id") String id){
        LOGGER.info("[Api:/diary/fetchDiarySet][Method:fetchDiarySet][param:id]--" + id);
        List<DiaryVO> diaryVOList = diaryService.fetchDiarySet(id);

        return diaryVOList;
    }
}
