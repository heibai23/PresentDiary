package com.mango.diary.business.diary.service.impl;

import com.mango.diary.business.bit.service.impl.BitRecordServiceImpl;
import com.mango.diary.business.diary.dao.DiaryDAO;
import com.mango.diary.business.diary.po.TDiary;
import com.mango.diary.business.diary.service.DiaryService;
import com.mango.diary.business.diary.vo.DiaryVO;
import com.mango.diary.common.utils.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Author：Mango Cheng
 * Date：2020/2/20
 * Time：16:55
 * Description：diary service implementation
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class DiaryServiceImpl implements DiaryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BitRecordServiceImpl.class);

    @Autowired
    private DiaryDAO diaryDAO;

    @Override
    public TDiary saveOrUpdate(DiaryVO diaryVO) {

        TDiary diary = new TDiary();
        BeanUtils.copyProperties(diaryVO, diary);
        // 新增或更新

        return diaryDAO.save(diary);
    }

    @Override
    public List<DiaryVO> fetchDiarySet(String id) {

        List<TDiary> diaryList = diaryDAO.findAll(Sort.by(Sort.Direction.DESC,"diaryTime"));
        LOGGER.info("[Method:fetchDiarySet][Data:diaryList]--"+diaryList.toString());
        List<DiaryVO> diaryVOList = ListUtils.copyList(diaryList);

        return diaryVOList;
    }
}
