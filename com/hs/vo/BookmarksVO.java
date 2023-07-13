package com.hs.vo;

/**
 * @author cc
 * 收藏夹视图
 */
public class BookmarksVO {
    /**
     * 收藏夹编号
     */
    private int bmid;
    /**
     * 收藏夹名称
     */
    private String bmname;

    /**
     * 账号对象视图
     */
    private AccountVO accountVO;

    public BookmarksVO() {
    }

    public BookmarksVO(int bmid, String bmname, AccountVO accountVO) {
        this.bmid = bmid;
        this.bmname = bmname;
        this.accountVO = accountVO;
    }

    @Override
    public String toString() {
        return "BookmarksVO{" +
                "bmid=" + bmid +
                ", bmname='" + bmname + '\'' +
                ", accountVO=" + accountVO +
                '}';
    }

    public int getBmid() {
        return bmid;
    }

    public void setBmid(int bmid) {
        this.bmid = bmid;
    }

    public String getBmname() {
        return bmname;
    }

    public void setBmname(String bmname) {
        this.bmname = bmname;
    }

    public AccountVO getAccountVO() {
        return accountVO;
    }

    public void setAccountVO(AccountVO accountVO) {
        this.accountVO = accountVO;
    }
}
