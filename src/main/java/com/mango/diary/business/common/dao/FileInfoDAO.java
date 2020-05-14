package com.mango.diary.business.common.dao;

import com.mango.diary.business.common.po.TFileInfo;
import com.mango.diary.common.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Author：Mango Cheng
 * Date：2020/1/19
 * Time：20:17
 * Description：文件信息
 */
@Repository
public interface FileInfoDAO extends BaseRepository<TFileInfo, String> {

    /**
     * 获取文件信息
     * @param id
     * @return
     */
    @Override
    Optional<TFileInfo> findById(String id);
}
