package com.mango.diary.common.enums;

/**
 * Author：Mango Cheng
 * Date：2020/1/12
 * Time：18:19
 * Description：常用枚举
 */
public enum UsuallyUseEnum {
    /**
     * 保存
     */
    SAVE(0,"save", "保存"),

    /**
     * 更新
     */
    UPDATE(1,"update", "更新");
    
    private int code;
    private String name;
    private String desc;

    UsuallyUseEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    UsuallyUseEnum(int code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
