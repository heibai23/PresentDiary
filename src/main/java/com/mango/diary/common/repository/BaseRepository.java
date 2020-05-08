package com.mango.diary.common.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Author：Mango Cheng
 * Date：2020/1/1
 * Time：17:00
 * Description：基础
 * 参考：https://www.jianshu.com/p/73f48095a7bf
 * NoRepositoryBean 不自动创建实例
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {


}
