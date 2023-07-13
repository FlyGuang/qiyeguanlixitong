package com.hs.vo;

import com.hs.po.Bookmarks;
import com.hs.po.Study;

/**
 * @author km
 * @author cc
 * 收藏内容视图类
 */
public class CollectVO {
    /**
     * 收藏编号
     */
    private int cid;
    /**
     * 学习内容
     */
    private Study study;
    /**
     * 收藏夹
     */
    private BookmarksVO bookmarksVO;

    public CollectVO() {
    }

    public CollectVO(int cid, Study study, BookmarksVO bookmarksVO) {
        this.cid = cid;
        this.study = study;
        this.bookmarksVO = bookmarksVO;
    }

    @Override
    public String toString() {
        return "CollectVO{" +
                "cid=" + cid +
                ", study=" + study +
                ", bookmarksVO=" + bookmarksVO +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }

    public BookmarksVO getBookmarksVO() {
        return bookmarksVO;
    }

    public void setBookmarksVO(BookmarksVO bookmarksVO) {
        this.bookmarksVO = bookmarksVO;
    }
}
