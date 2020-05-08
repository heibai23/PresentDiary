package com.mango.diary.business.diary.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Author：Mango Cheng
 * Date：2020/2/20
 * Time：16:52
 * Description：日记
 */
@Entity
@Table(name = "t_diary", schema = "diary", catalog = "")
@ApiModel(value = "日记实体类")
public class TDiary {
    @ApiModelProperty(value = "主键")
    private short id;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "心情")
    private String mood;
    @ApiModelProperty(value = "内容")
    private String richContent;
    @ApiModelProperty(value = "日期-天")
    private Timestamp diaryTime;

    @Id
    @Column(name = "id")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "mood")
    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    @Basic
    @Column(name = "rich_content")
    public String getRichContent() {
        return richContent;
    }

    public void setRichContent(String richContent) {
        this.richContent = richContent;
    }

    @Basic
    @Column(name = "diary_time")
    public Timestamp getDiaryTime() {
        return diaryTime;
    }

    public void setDiaryTime(Timestamp diaryTime) {
        this.diaryTime = diaryTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TDiary tDiary = (TDiary) o;
        return id == tDiary.id &&
                Objects.equals(title, tDiary.title) &&
                Objects.equals(mood, tDiary.mood) &&
                Objects.equals(richContent, tDiary.richContent) &&
                Objects.equals(diaryTime, tDiary.diaryTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, mood, richContent, diaryTime);
    }
}
