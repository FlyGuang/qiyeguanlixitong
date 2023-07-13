package com.hs.dao;

import com.hs.po.Record;
import com.hs.vo.RecordVO;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author 陈晨
 * 会议记录数据访问
 */
public interface RecordDao {
    /**
     * 查找所有会议记录
     * @return 会议记录集合视图
     */
    public List<RecordVO> findVOAll();
    /**
     * 查找所有会议记录
     * @return 会议记录集合
     */
    public List<Record> findAll();

    /**
     * 根据会议记录编号查找会议记录对象
     * @param reid 会议记录编号
     * @return 会议记录对象视图
     */
    public RecordVO findVOByReid(int reid);
    /**
     * 根据会议记录编号查找会议记录对象
     * @param reid 会议记录编号
     * @return 会议记录对象
     */
    public Record findByReid(int reid);
    /**
     * 根据会议编号查找会议记录对象
     * @param mid 会议编号
     * @return 会议记录对象视图
     */
    public RecordVO findVOByMid(int mid);
    /**
     * 根据会议编号查找会议记录对象
     * @param mid 会议编号
     * @return 会议记录对象
     */
    public Record findByMid(int mid);
    /**
     * 根据会议开始时间查找会议记录
     * @param rtime 会议的开始时间
     * @return 会议记录对象集合视图
     */
    public List<RecordVO> findVOByRtime(Timestamp rtime);
    /**
     * 根据会议开始时间查找会议记录
     * @param rtime 会议的开始时间
     * @return 会议记录对象集合
     */
    public List<Record> findByRtime(Timestamp rtime);
    /**
     * 新增会议记录
     * @param record 会议记录对象
     * @return 受影响的行数
     */
    public int add(Record record);

    /**
     * 更改会议记录
     * @param record 会议记录对象
     * @return 受影响的行数
     */
    public int update(Record record);
}
