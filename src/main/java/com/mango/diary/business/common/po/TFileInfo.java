package com.mango.diary.business.common.po;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * Author：Mango Cheng
 * Date：2020/1/19
 * Time：20:56
 * Description：
 */
@Entity
@Table(name = "t_file_info", schema = "diary", catalog = "")
public class TFileInfo {
    private String id;
    private String name;
    private String type;
    private byte[] data;
    private String size;

    @Id
    @Column
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "data")
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Basic
    @Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TFileInfo tFilesInfo = (TFileInfo) o;
        return Objects.equals(id, tFilesInfo.id) &&
                Objects.equals(name, tFilesInfo.name) &&
                Objects.equals(type, tFilesInfo.type) &&
                Arrays.equals(data, tFilesInfo.data) &&
                Objects.equals(size, tFilesInfo.size);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, type, size);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
