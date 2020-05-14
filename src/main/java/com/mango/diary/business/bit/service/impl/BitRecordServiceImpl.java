package com.mango.diary.business.bit.service.impl;

import com.mango.diary.business.bit.dao.BitRecordDAO;
import com.mango.diary.business.bit.po.TBitRecord;
import com.mango.diary.business.bit.service.BitRecordService;
import com.mango.diary.business.bit.vo.TimeLineVO;
import com.mango.diary.common.enums.UsuallyUseEnum;
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
 * Date：2020/1/1
 * Time：17:27
 * Description：服务实现
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class BitRecordServiceImpl implements BitRecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BitRecordServiceImpl.class);

    @Autowired
    private BitRecordDAO bitRecordDAO;

    @Override
    public TBitRecord findById(int id) {

        return bitRecordDAO.getOne(id);
    }

    @Override
    public TBitRecord saveOrUpdate(int type, TimeLineVO timeLineVO) {

        TBitRecord bitRecord = new TBitRecord();
        BeanUtils.copyProperties(timeLineVO, bitRecord);
        // 富文本数据处理 HtmlUtils


        if (UsuallyUseEnum.SAVE.getCode() == type) {
            // 保存
        } else if (UsuallyUseEnum.UPDATE.getCode() == type) {
            // 更新
        }
        return bitRecordDAO.save(bitRecord);
    }

    @Override
    public List<TimeLineVO> fetchBitData() {
        // 时间倒序，查询所有数据
        List<TBitRecord> bitRecordList = bitRecordDAO.findAll(Sort.by(Sort.Direction.DESC, "recordTime"));
        LOGGER.info("[Service][Data:bitRecord]" + bitRecordList);
        List<TimeLineVO> timeLineVOList = ListUtils.copyList(bitRecordList);
        LOGGER.info("[Service][Data:timeLineVOList]" + timeLineVOList);

        return timeLineVOList;
    }


}
