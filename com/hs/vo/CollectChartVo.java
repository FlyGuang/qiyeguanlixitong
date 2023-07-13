package com.hs.vo;

/**
 * @author cc
 * 图形视图
 */
public class CollectChartVo {

    /**
     * 内容标题
     */
    private String stutitle;
    /**
     * 用户发表的帖子数
     */
    private int value;

    public CollectChartVo() {
    }

    public CollectChartVo(String stutitle, int value) {
        this.stutitle = stutitle;
        this.value = value;
    }

    public String getStutitle() {
        return stutitle;
    }

    public void setStutitle(String stutitle) {
        this.stutitle = stutitle;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
