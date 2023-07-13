package com.hs.service;

import com.hs.po.Bookmarks;
import com.hs.vo.BookmarksVO;

import java.util.List;

/**
 * @author 陈晨
 * 收藏夹业务逻辑接口
 */
public interface BookmarksService {
    /**
     * 查找所有收藏夹
     * @return 个人收藏夹集合视图
     */
    public List<BookmarksVO> findVOAll();
    /**
     * 查找所有收藏夹
     * @return 个人收藏夹集合
     */
    public List<Bookmarks> findAll();
    /**
     * 根据收藏夹编号查找收藏夹对象
     * @param bmid 收藏夹编号
     * @return 收藏夹对象视图
     */
    public BookmarksVO findVOByBmid(int bmid);
    /**
     * 根据收藏夹编号查找收藏夹对象
     * @param bmid 收藏夹编号
     * @return 收藏夹对象
     */
    public Bookmarks findByBmid(int bmid);
    /**
     * 根据账号编号查找收藏夹集合
     * @param aid 账号编号
     * @return 收藏夹集合视图
     */
    public List<BookmarksVO> findVOByAid(int aid);
    /**
     * 根据账号编号查找收藏夹集合
     * @param aid 账号编号
     * @return 收藏夹集合
     */
    public List<Bookmarks> findByAid(int aid);
    /**
     * 新建收藏夹
     * @param bookmarks 收藏夹对象
     * @return 受影响的行数
     */
    public boolean add(Bookmarks bookmarks);

    /**
     * 更改收藏夹
     * @param bookmarks 收藏夹对象
     * @return 受影响的行数
     */
    public boolean update(Bookmarks bookmarks);

    /**
     * 根据收藏夹编号删除收藏夹
     * @param bmid 收藏夹编号
     * @return 受影响的行数
     */
    public boolean delete(int bmid);
}
