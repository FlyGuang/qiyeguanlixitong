package com.hs.vo;

/**
 * @author bilie
 * 进度的视图
 */
public class Progress {

    /**
     * 进度数值
     */
    private int ppnum;

    /**
     * 项目名称
     */
    private String pname;

    public Progress() {
    }

    public Progress(int ppnum, String pname) {

        this.ppnum = ppnum;
        this.pname = pname;
    }

    public int getPpnum() {
        return ppnum;
    }

    public void setPpnum(int ppnum) {
        this.ppnum = ppnum;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
