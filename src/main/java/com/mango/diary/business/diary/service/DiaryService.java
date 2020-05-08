package com.mango.diary.business.diary.service;

import com.mango.diary.business.diary.po.TDiary;
import com.mango.diary.business.diary.vo.DiaryVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author：Mango Cheng
 * Date：2020/2/20
 * Time：16:55
 * Description：diary Service
 */
public interface DiaryService {

    /**
     * 新增或更新
     * @param diaryVO
     * @return
     */
    TDiary saveOrUpdate(DiaryVO diaryVO);

    /**
     * 查找日记集
     * @param id
     * @return
     */
    List<DiaryVO> fetchDiarySet(String id);

}
