package com.mango.diary.business.bit.vo;

import com.mango.diary.business.bit.po.TBitRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

/**
 * Author: Mango Cheng
 * Date: 2019/12/21
 * Time: 19:40
 * Description: 时间轴扩展类
 */
@ToString
@ApiModel("时间轴")
public class TimeLineVO extends TBitRecord{

    /**
     * 保存类型：0--新增、1--更新
     */
    @ApiModelProperty("保存类型：0--新增、1--更新")
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
