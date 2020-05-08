package com.mango.diary.business.diary.dao;

import com.mango.diary.business.diary.po.TDiary;
import com.mango.diary.common.repository.BaseRepository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.stereotype.Repository;

/**
 * Author：Mango Cheng
 * Date：2020/2/20
 * Time：16:53
 * Description：diary
 */
@Repository
public interface DiaryDAO extends BaseRepository<TDiary, ID> {

}
