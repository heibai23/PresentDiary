package com.mango.diary.common.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author：Mango Cheng
 * Date：2020/1/3
 * Time：19:43
 * Description：集合工具类
 */
public class ListUtils {

    /**
     * 集合数据对象拷贝
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List copyList(List<T> list) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList();
        }
        return JSON.parseArray(JSON.toJSONString(list), list.get(0).getClass());
    }

    public static Map<String, Object> copyMap(Map map) {
        return JSON.parseObject(JSON.toJSONString(map));
    }

}
