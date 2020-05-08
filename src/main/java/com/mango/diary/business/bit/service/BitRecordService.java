package com.mango.diary.business.bit.service;

import com.mango.diary.business.bit.po.TBitRecord;
import com.mango.diary.business.bit.vo.TimeLineVO;

import java.util.List;

/**
 * Author：Mango Cheng
 * Date：2020/1/1
 * Time：17:24
 * Description：
 */
public interface BitRecordService {

    /**
     * 获取数据
     * @param id
     * @return
     */
    TBitRecord findById(int id);

    /**
     * 保存或更新
     * @param type
     * @param timeLineVO
     * @return
     */
    TBitRecord saveOrUpdate(int type, TimeLineVO timeLineVO);

    List<TimeLineVO> fetchBitData();
}
