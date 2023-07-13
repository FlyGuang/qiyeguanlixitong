package com.hs.po;

import java.sql.Timestamp;

/**
 * @author awei
 * 学习内容实体类
 */
public class Study {

    /**
     * 学习内容编号（主键）
     */
    private int stuid;

    /**
     * 学习内容标题
     */
    private String stutitle;

    /**
     * 链接地址
     */
    private String stuaddr;
    /**
     * 图片地址
     */
    private String imgaddr;

    public Study() {
    }

    public Study(int stuid, String stutitle, String stuaddr, String imgaddr) {
        this.stuid = stuid;
        this.stutitle = stutitle;
        this.stuaddr = stuaddr;
        this.imgaddr = imgaddr;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStutitle() {
        return stutitle;
    }

    public void setStutitle(String stutitle) {
        this.stutitle = stutitle;
    }

    public String getStuaddr() {
        return stuaddr;
    }

    public void setStuaddr(String stuaddr) {
        this.stuaddr = stuaddr;
    }

    public String getImgaddr() {
        return imgaddr;
    }

    public void setImgaddr(String imgaddr) {
        this.imgaddr = imgaddr;
    }
}
