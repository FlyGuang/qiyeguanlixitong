package com.hs.service.impl;

import com.hs.dao.BookmarksDao;
import com.hs.po.Bookmarks;
import com.hs.service.BookmarksService;
import com.hs.vo.BookmarksVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈晨
 * 收藏夹业务逻辑实现类
 */
@Service
public class BookmarksServiceImpl implements BookmarksService {
    @Autowired
    BookmarksDao bookmarksDao;

    @Override
    public List<BookmarksVO> findVOAll() {
        return bookmarksDao.findVOAll();
    }

    @Override
    public List<Bookmarks> findAll() {
        return bookmarksDao.findAll();
    }

    @Override
    public BookmarksVO findVOByBmid(int bmid) {
        return bookmarksDao.findVOByBmid(bmid);
    }

    @Override
    public Bookmarks findByBmid(int bmid) {
        return bookmarksDao.findByBmid(bmid);
    }

    @Override
    public List<BookmarksVO> findVOByAid(int aid) {
        return bookmarksDao.findVOByAid(aid);
    }

    @Override
    public List<Bookmarks> findByAid(int aid) {
        return bookmarksDao.findByAid(aid);
    }

    @Override
    public boolean add(Bookmarks bookmarks) {
        return bookmarksDao.add(bookmarks)>0?true:false;
    }

    @Override
    public boolean update(Bookmarks bookmarks) {
        return bookmarksDao.update(bookmarks)>0?true:false;
    }

    @Override
    public boolean delete(int bmid) {
        return bookmarksDao.delete(bmid)>0?true:false;
    }
}
